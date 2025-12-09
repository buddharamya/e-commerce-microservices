package com.microserviceprojects.user_service.Mapper;

import com.microserviceprojects.user_service.DTO.CredentialDTO;
import com.microserviceprojects.user_service.Entity.CredentialEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CredentialMapper {

    CredentialEntity toEntity(CredentialDTO dto);
    CredentialDTO toDTO(CredentialEntity entity);

}
