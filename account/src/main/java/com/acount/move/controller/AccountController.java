package com.acount.move.controller;

import com.acount.move.model.AccountRequest;
import com.acount.move.model.AccountResponse;
import com.acount.move.services.AccountServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/cuentas")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServices accountServices;

    @PostMapping
    public Mono<ResponseEntity<AccountResponse>> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        return accountServices.createAccount(accountRequest)
                .map(accountResponse -> ResponseEntity.status(HttpStatus.CREATED).body(accountResponse));
    }

    @PutMapping("/{accountNumber}")
    public Mono<ResponseEntity<AccountResponse>> inactivateAccount(@PathVariable String accountNumber) {
        return accountServices.inactivateAccount(accountNumber)
                .map(accountResponse -> ResponseEntity.status(HttpStatus.OK).body(accountResponse));
    }

    @GetMapping
    public Flux<AccountResponse> listAccount() {
        return accountServices.listAccount();
    }


    @GetMapping("/{accountNumber}")
    public Mono<ResponseEntity<AccountResponse>> getAccount(@PathVariable String accountNumber) {
        return accountServices.getAccount(accountNumber)
                .map(accountResponse -> ResponseEntity.status(HttpStatus.OK).body(accountResponse))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NO_CONTENT).body(AccountResponse.builder().build())));
    }
}
