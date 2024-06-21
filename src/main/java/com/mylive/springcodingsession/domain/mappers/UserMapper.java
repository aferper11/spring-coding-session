package com.mylive.springcodingsession.domain.mappers;

import com.mylive.springcodingsession.domain.dtos.UserDTO;
import com.mylive.springcodingsession.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTO(List<User> group);

    User fromUserDTO(UserDTO userDTO);
}
