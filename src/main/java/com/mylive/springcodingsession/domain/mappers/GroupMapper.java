package com.mylive.springcodingsession.domain.mappers;

import com.mylive.springcodingsession.domain.dtos.GroupDTO;
import com.mylive.springcodingsession.domain.entities.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    GroupDTO toGroupDTO(Group group);

    List<GroupDTO> toGroupDTO(List<Group> group);

    Group fromGroupDTO(GroupDTO groupDTO);
}
