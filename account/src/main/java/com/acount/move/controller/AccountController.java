package com.acount.move.controller;

import com.acount.move.model.AccountRequest;
import com.acount.move.model.AccountResponse;
import com.acount.move.services.AccountServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
