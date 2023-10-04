package com.cliente.move.services;

import com.cliente.move.model.ClientRequest;
import com.cliente.move.model.ClientResponse;
import com.cliente.move.repository.ClientRepository;
import com.cliente.move.repository.PersonRepository;
import com.cliente.move.repository.entity.ClientEntity;
import com.cliente.move.repository.entity.PersonEntity;
import com.cliente.move.services.mapper.ClientMapper;
import com.cliente.move.util.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
        return Mono.defer(() -> {
            PersonEntity personEntity = clientMapper.toEntityPerson(clientRequest);

            return personRepository.save(personEntity)
                    .flatMap(personResponse -> {
                        ClientEntity clientEntity = clientMapper.toEntityClient(personResponse);
                        log.info("person id: {}", clientEntity.getPersonID());
                        return clientRepository.save(clientMapper.toEntityClient(personResponse))
                                .map(clientResponse -> {
                                    log.info("client id: {}", clientResponse.getClientID());
                                    return clientMapper.toClientResponse(clientResponse);
                                });
                    })
                    .switchIfEmpty(Mono.error(new CustomException("La inserción en la tabla person falló.")))
                    .onErrorResume(error -> {
                        log.error("Error al insertar en la tabla person: {}", error.getMessage());
                        return Mono.error(error);
                    });
        });
    }







}
