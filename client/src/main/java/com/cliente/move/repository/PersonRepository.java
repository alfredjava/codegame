package com.cliente.move.repository;

import com.cliente.move.repository.entity.PersonEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<PersonEntity, Long> {
}
