package com.acount.move.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDateTime;

@Table(value = "move")
@Getter
@Setter
@Builder
public class MoveEntity {

    @Id
    private Long moveID;
    private LocalDateTime moveDate;
    private String moveType;
    private Double amount;
    @With
    private String description;
    @With
    private Long accountID;


    @Transient
    private String accountNumber;
    @With
    @Transient
    private Double balance;

}
