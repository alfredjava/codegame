package com.acount.move.repository;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class MoveDTO {
    private Long moveID;
    private LocalDateTime moveDate;
    private String moveType;
    private Double amount;
    @With
    private String description;
    @With
    private Long accountID;
    private String accountNumber;
    private Double initialBalance;
}
