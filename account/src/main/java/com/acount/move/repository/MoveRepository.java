package com.acount.move.repository;


import com.acount.move.repository.entity.MoveEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MoveRepository extends ReactiveCrudRepository<MoveEntity,Long> {

    @Query("SELECT m.move_id, m.move_date, m.move_type, m.amount, m.description, m.account_id,  a.account_number as accountNumber FROM move m , account a " +
            "WHERE a.account_id = m.account_id and a.account_number = :accountNumber")
    Flux<MoveEntity> findByAccountNumber(String accountNumber);
}
