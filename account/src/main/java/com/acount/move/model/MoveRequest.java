package com.acount.move.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MoveRequest {
        @NotBlank(message = "accountNumber is required")
        @Pattern(regexp = "^[0-9]{6}$", message = "accountNumber must be a 6-digit numeric value")
        private String accountNumber;
        private Double amount;
        @NotBlank(message = "type is required")
        @Pattern(regexp = "^(Retiro|Deposito)$",
                message = "The accountType is one of the following: Retiro o Deposito.")
        private String type;
}
