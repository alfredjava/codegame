package com.acount.move.services;

import com.acount.move.model.AccountRequest;
import com.acount.move.model.AccountResponse;
import reactor.core.publisher.Mono;

public interface AccountServices {

    Mono<AccountResponse> createAccount(AccountRequest accountRequest);
}
