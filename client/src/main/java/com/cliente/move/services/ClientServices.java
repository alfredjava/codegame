package com.cliente.move.services;

import com.cliente.move.model.ClientRequest;
import com.cliente.move.model.ClientResponse;
import reactor.core.publisher.Mono;

public interface ClientServices {

    Mono<ClientResponse> createPerson(ClientRequest clientRequest);
}
