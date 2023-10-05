package com.acount.move.repository;

import com.acount.move.repository.entity.AccountEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveCrudRepository<AccountEntity,Long> {
    Mono<AccountEntity> findByAccountNumber(String accountNumber);
}
