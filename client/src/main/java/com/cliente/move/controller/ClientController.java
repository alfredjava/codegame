package com.cliente.move.controller;

import com.cliente.move.model.ClientRequest;
import com.cliente.move.model.ClientResponse;
import com.cliente.move.services.ClientServices;
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
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {


    private final ClientServices clientServices;

    @PostMapping
    public Mono<ResponseEntity<ClientResponse>> createPerson(@Valid @RequestBody ClientRequest clientRequest) {
        return clientServices.createPerson(clientRequest)
                .map(clientResponse -> ResponseEntity.status(HttpStatus.CREATED).body(clientResponse));
    }

}
