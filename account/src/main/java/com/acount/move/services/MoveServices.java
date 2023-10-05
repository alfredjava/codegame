package com.acount.move.services;

import com.acount.move.model.MoveRequest;
import com.acount.move.model.MoveResponse;
import com.acount.move.repository.MoveDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MoveServices {
    Mono<MoveResponse> createMove(MoveRequest moveRequest);
    Flux<MoveResponse> listMoveByAccountID(String accountID);

    Flux<MoveResponse> listMoveAll();

    Flux<MoveResponse> listMoveByAccountNumber(String accountNumber);
}
