package com.acount.move.controller;

import com.acount.move.model.AccountRequest;
import com.acount.move.model.AccountResponse;
import com.acount.move.model.MoveRequest;
import com.acount.move.model.MoveResponse;
import com.acount.move.services.MoveServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/movimientos")
@RequiredArgsConstructor
public class MoveController {

    private final MoveServices moveServices;

    // create postmapping for createMove
    @PostMapping
    public Mono<ResponseEntity<MoveResponse>> createMove(@Valid @RequestBody MoveRequest moveRequest) {
        return moveServices.createMove(moveRequest)
                .map(moveResponse -> ResponseEntity.status(HttpStatus.CREATED).body(moveResponse));
    }

    // create getmapping for listMoveByAccount
    @GetMapping("/{accountNumber}")
    public Flux<ResponseEntity<MoveResponse>> listMoveByAccount(@PathVariable String accountNumber) {
        return moveServices.listMoveByAccount(accountNumber)
                .map(moveResponse -> ResponseEntity.status(HttpStatus.OK).body(moveResponse))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NO_CONTENT).body(MoveResponse.builder().build())));
    }


}
