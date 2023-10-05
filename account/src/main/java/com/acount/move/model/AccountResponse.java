package com.acount.move.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AccountResponse {

    private Long accountID;
    private String accountNumber;
    private Boolean status;
    private String accountType;
    private Double balance;
}
