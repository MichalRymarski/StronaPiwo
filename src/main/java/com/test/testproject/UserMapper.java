package com.test.testproject;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper { //wiecej warst abtrakcji + bezpieczniej
    UserMapper INSTACE = Mappers.getMapper(UserMapper.class); //interfejs z jedna istancja
    UserDTO toDTO(User user); //mapowanie entity na DTO
    User toEntity(UserDTO userDTO); //mapowanie DTO na entity

}
