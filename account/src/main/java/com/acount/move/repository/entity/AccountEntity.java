package com.acount.move.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
        private Boolean status;
        private Long clientID;
}
