package com.acount.move.repository;


import com.acount.move.repository.entity.MoveEntity;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface MoveRepository extends ReactiveCrudRepository<MoveEntity,Long> {

    @Query("SELECT m.move_id, m.move_date, m.move_type, m.amount, m.description, m.account_id, " +
            " a.account_number , a.initial_balance  FROM move m JOIN account a ON m.account_id = a.account_id " +
            "WHERE a.account_number = :accountNumber")
    Flux<MoveDTO> findByAccountNumber(@Param("accountNumber") String accountNumber);
    @Query("SELECT m.move_id, m.move_date, m.move_type, m.amount, m.description, m.account_id, " +
            " a.account_number , a.initial_balance  FROM move m JOIN account a ON m.account_id = a.account_id ")
    Flux<MoveDTO> findAllMoves();



    Flux<MoveEntity> findByAccountID(Long accountID);
}
