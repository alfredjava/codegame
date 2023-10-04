package com.acount.move.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequest {

    @NotBlank(message = "accountType is required")
    @Pattern(regexp = "^(Corriente|Ahorros)$",
            message = "The accountType is one of the following: Corriente o Ahorros.")
    private String accountType;
    @NotNull(message = "El ID del cliente es requerido")
    @Digits(integer = 10, fraction = 0, message = "El ID del cliente debe ser un número entero de hasta 10 dígitos")
    private Long clientID;
}
