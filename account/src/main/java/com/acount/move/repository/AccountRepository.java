package com.acount.move.repository;

import com.acount.move.repository.entity.AccountEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AccountRepository extends ReactiveCrudRepository<AccountEntity,Long> {
}
