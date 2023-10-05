package com.acount.move.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "account")
@Getter
@Setter
@Builder
public class AccountEntity {
        @Id
        private Long accountID;
        private String accountNumber;
        private String accountType;
        private Double initialBalance;
        @With
        private Boolean status;
        private Long clientID;
}
