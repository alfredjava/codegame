package com.acount.move.services;

import com.acount.move.model.MoveRequest;
import com.acount.move.model.MoveResponse;
import com.acount.move.repository.AccountRepository;
import com.acount.move.repository.MoveRepository;
import com.acount.move.services.mapper.MoveMapper;
import com.acount.move.util.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
@Component
@Slf4j
public class MoveServicesImpl implements MoveServices{

    private final MoveRepository moveRepository;
    private final AccountRepository accountRepository;
    private final MoveMapper moveMapper;
    @Override
    @Transactional
    public Mono<MoveResponse> createMove(MoveRequest moveRequest) {
        // create move if account exist
        return accountRepository.findByAccountNumber(moveRequest.getAccountNumber())
                .switchIfEmpty(Mono.error(new CustomException("Account not found")))
                .flatMap(accountEntity -> {
                    // validate if account is active
                    if (!accountEntity.getStatus()){
                        return Mono.error(new CustomException("Account is inactive"));
                    }
                    // validate account balance Retiro
                    if (moveRequest.getType().equals("Retiro") && accountEntity.getInitialBalance() < moveRequest.getAmount()){
                        return Mono.error(new CustomException("saldo no disponible"));
                    }
                    // if move is Retiro, subtract amount from account balance
                    if (moveRequest.getType().equals("Retiro")){
                        accountEntity.setInitialBalance(accountEntity.getInitialBalance() - moveRequest.getAmount());
                    } else {
                        // if move is Deposito, add amount to account balance
                        accountEntity.setInitialBalance(accountEntity.getInitialBalance() + moveRequest.getAmount());
                    }

                    // save account if save move is success
                    return moveRepository.save(moveMapper.moveToEntity(moveRequest)
                                    //.withAccountNumber(accountEntity.getAccountNumber())
                                    .withAccountID(accountEntity.getAccountID())
                                    .withBalance(accountEntity.getInitialBalance())
                                    .withDescription(moveRequest.getType() + " " + moveRequest.getAmount()))
                            .map(moveMapper::moveEntityToMoveResponse)
                            .doOnSuccess(moveRequest1 -> {
                                accountRepository.save(accountEntity)
                                        .doOnError(throwable -> log.error("Error saving account: {}", throwable.getMessage()))
                                        .subscribe();
                            }).doOnError(throwable -> log.error("Error creating move: {}", throwable.getMessage()));
                });
    }

    @Override
    public Flux<MoveResponse> listMoveByAccount(String accountNumber) {
        return moveRepository.findByAccountNumber(accountNumber).map(moveMapper::moveEntityToMoveResponse);
    }
}
