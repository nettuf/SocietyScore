package com.societyscore.authservice.Model.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.societyscore.authservice.Model.Entities.User;
import com.societyscore.authservice.Model.InputDTO.UserInputDTO;
import com.societyscore.authservice.Model.OutputDTO.UserOutputDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Converte UserInputDTO -> User
    @Mapping(target = "id", ignore = true) // ID será gerado automaticamente
    @Mapping(target = "status", ignore = true) // Status pode ter um valor padrão
    User toEntity(UserInputDTO dto);

    // Converte User -> UserOutputDTO
    UserOutputDTO toOutputDTO(User user);
}