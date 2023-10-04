package com.cliente.move.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Setter
@Getter
public class ClientRequest {

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 200, message = "The name must be from 3 to 200 characters.")
    private String name;
    @NotBlank(message = "gender is required")
    @Pattern(regexp = "^[MFO]$",
            message = "The gender is one of the following: M, F, O.")
    private String gender;
    private Integer age;
    @NotBlank(message = "identification is required")
    private String identification;
    private String address;
    private String phone;
    @NotBlank(message = "The password is required.")
    private String password;

}
