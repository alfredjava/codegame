package com.acount.move.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MoveResponse {

        private Long moveID;
        private String accountNumber;
        private Double amount;
        private String type;
        private String date;
        private Double balance;
        private String description;
}
