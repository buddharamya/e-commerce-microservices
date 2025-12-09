package com.microserviceprojects.user_service.Mapper;

import com.microserviceprojects.user_service.DTO.UserDTO;
import com.microserviceprojects.user_service.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
        componentModel="spring",
        uses = {CredentialMapper.class}
)
public interface UserMapper {

    @Mappings({

            @Mapping(source="email",target="emailAddress"),
            @Mapping(source="phone",target="contact")
    })
    UserDTO toDTO(UserEntity user);

    @Mappings({

            @Mapping(source="emailAddress",target="email"),
            @Mapping(source="contact",target="phone")
    })
    UserEntity toEntity(UserDTO userDto);
}
