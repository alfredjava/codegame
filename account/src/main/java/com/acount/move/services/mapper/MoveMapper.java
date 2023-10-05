package com.acount.move.services.mapper;

import com.acount.move.model.MoveRequest;
import com.acount.move.model.MoveResponse;
import com.acount.move.repository.entity.MoveEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MoveMapper {
    @Mapping(target ="moveDate",expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target ="moveType",source = "type")
    MoveEntity moveToEntity(MoveRequest moveRequest);

    @Mapping(target ="accountNumber",source = "accountNumber")
    @Mapping(target ="type",source = "moveType")
    @Mapping(target ="date",expression = "java(converseStringToLocalDateTime(moveEntity.getMoveDate()))")
    @Mapping(target ="balance",source = "balance")
    @Mapping(target ="description",source = "description")
    MoveResponse moveEntityToMoveResponse(MoveEntity moveEntity);

    default String converseStringToLocalDateTime(java.time.LocalDateTime localDateTime){
        // conver LocalDateTime to String using format yyyy-MM-dd HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
