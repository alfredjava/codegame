package com.cliente.move.services;

import com.cliente.move.model.ClientRequest;
import com.cliente.move.model.ClientResponse;
import com.cliente.move.repository.ClientRepository;
import com.cliente.move.repository.PersonRepository;
import com.cliente.move.services.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
@Slf4j
public class ClientServicesImpl implements ClientServices {

    private final ClientRepository clientRepository;
    private final PersonRepository personRepository;
    private final ClientMapper clientMapper;

    @Override
    public Mono<ClientResponse> createPerson(ClientRequest clientRequest) {
        return personRepository.save(clientMapper.toEntityPerson(clientRequest))
                //.doOnSuccess(personResponse -> clientRepository.save(clientMapper.toEntityClient(personResponse)))
                .map(personaEntity -> clientMapper.toClientResponse(personaEntity));
    }
}
