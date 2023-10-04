package com.cliente.move.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "client")
@Getter
@Setter
@Builder
public class ClientEntity {

    @Id
    private Long clientID;
    private String password;
    private Boolean status;
    private Long personID;
}
