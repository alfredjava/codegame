package com.acount.move.services;

import com.acount.move.model.AccountRequest;
import com.acount.move.model.AccountResponse;
import com.acount.move.repository.AccountRepository;
import com.acount.move.services.mapper.AccountMapper;
import com.acount.move.util.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
@Slf4j
public class AccountServicesImpl implements AccountServices {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public Mono<AccountResponse> createAccount(AccountRequest accountRequest) {
        return accountRepository.save(accountMapper.accountRequestToAccountEntity(accountRequest).withStatus(true))
                .map(accountMapper::accountEntityToAccountResponse);
    }

    @Override
    public Mono<AccountResponse> inactivateAccount(String accountNumber) {
        // Buscar la cuenta por su número de cuenta
        return accountRepository.findByAccountNumber(accountNumber)
                .switchIfEmpty(Mono.error(new CustomException("La cuenta no existe")))
                .flatMap(accountEntity -> {
                    // Actualizar el estado de la cuenta a false
                    return accountRepository.save(accountEntity.withStatus(false))
                            .map(accountMapper::accountEntityToAccountResponse);
                });
    }


    @Override
    public Flux<AccountResponse> listAccount() {
        return accountRepository.findAll()
                .map(accountMapper::accountEntityToAccountResponse);

    }

    @Override
    public Mono<AccountResponse> getAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(accountMapper::accountEntityToAccountResponse);
    }
}
