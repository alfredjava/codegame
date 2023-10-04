package com.cliente.move.services.mapper;

import com.cliente.move.model.ClientRequest;
import com.cliente.move.model.ClientResponse;
import com.cliente.move.repository.entity.ClientEntity;
import com.cliente.move.repository.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientMapper {



    @Mapping(target ="name",source = "name")
    PersonEntity toEntityPerson(ClientRequest clientRequest);

    ClientEntity toEntityClient(PersonEntity personResponse);

    ClientResponse toClientResponse(PersonEntity personaEntity);
}




