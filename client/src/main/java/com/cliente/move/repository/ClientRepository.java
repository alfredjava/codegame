package com.cliente.move.repository;

import com.cliente.move.repository.entity.ClientEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClientRepository extends ReactiveCrudRepository<ClientEntity,Long> {
}
