package com.acount.move.services.mapper;

import com.acount.move.model.AccountRequest;
import com.acount.move.model.AccountResponse;
import com.acount.move.repository.entity.AccountEntity;
import com.acount.move.util.AccountUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper {

    @Mapping(target ="accountNumber",expression = "java(generateAccountNumber())")
    @Mapping(target ="accountType",source = "accountType")
    @Mapping(target ="initialBalance",expression = "java(0.0)")
    @Mapping(target ="status",expression = "java(false)")
    AccountEntity accountRequestToAccountEntity(AccountRequest accountRequest);

    default String generateAccountNumber(){

        return AccountUtil.generateAccountNumber();
    }
    @Mapping(target ="accountID",source = "accountID")
    @Mapping(target ="accountNumber",source = "accountNumber")
    @Mapping(target ="status",source = "status")
    @Mapping(target ="balance",source = "initialBalance")
    AccountResponse accountEntityToAccountResponse(AccountEntity accountEntity);
}
