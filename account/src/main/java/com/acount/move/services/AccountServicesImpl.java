package com.acount.move.services;

import com.acount.move.model.AccountRequest;
import com.acount.move.model.AccountResponse;
import com.acount.move.repository.AccountRepository;
import com.acount.move.services.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
@Slf4j
public class AccountServicesImpl implements AccountServices {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public Mono<AccountResponse> createAccount(AccountRequest accountRequest) {
        return accountRepository.save(accountMapper.accountRequestToAccountEntity(accountRequest))
                .map(accountMapper::accountEntityToAccountResponse);
    }
}
