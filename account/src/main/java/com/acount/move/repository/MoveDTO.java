package com.acount.move.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class MoveDTO {
    @Id
    private Long moveID;
    private LocalDateTime moveDate;
    private String moveType;
    private Double amount;
    @With
    private String description;
    @With
    private Long accountID;
    private String accountNumber;
    private Double balance;
}
