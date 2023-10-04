package com.cliente.move.controller;

import com.cliente.move.model.ClientRequest;
import com.cliente.move.model.ClientResponse;
import com.cliente.move.services.ClientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClienteController {


    private final ClientServices clienteServices;
    @PostMapping
    public Mono<ResponseEntity<ClientResponse>> createPerson(@RequestBody ClientRequest clientRequest, ServerWebExchange exchange){
        return clienteServices.createPerson(clientRequest)
                .doOnSuccess(clientResponse -> exchange.getResponse().setStatusCode(HttpStatus.CREATED))
                .map(ResponseEntity::ok);

    }
}
