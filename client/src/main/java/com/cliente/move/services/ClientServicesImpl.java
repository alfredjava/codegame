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
        PersonEntity personEntity = clientMapper.toEntityPerson(clientRequest);

        return personRepository.findByIdentification(personEntity.getIdentification())
                .flatMap(existingPerson -> {
                    // Si la persona ya existe
                    return Mono.error(new CustomException("La persona ya existe."));
                })
                .switchIfEmpty(Mono.defer(() -> {
                    return personRepository.save(personEntity)
                            .map(savedPerson -> {
                                // Crear el cliente
                                ClientEntity clientEntity = clientMapper.toEntityClient(savedPerson);
                                clientEntity.setPassword(clientRequest.getPassword());
                                clientEntity.setStatus(true);
                                return clientEntity;
                            })
                            .flatMap(clientRepository::save)
                            .map(savedClient -> clientMapper.toClientResponse(savedClient));
                }))
                .cast(ClientResponse.class);
    }







}
