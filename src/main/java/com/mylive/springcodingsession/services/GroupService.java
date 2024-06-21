package com.mylive.springcodingsession.services;

import com.mylive.springcodingsession.domain.dtos.GroupDTO;
import com.mylive.springcodingsession.domain.mappers.GroupMapper;
import com.mylive.springcodingsession.repository.GroupRepository;
import com.mylive.springcodingsession.rest.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	public List<GroupDTO> retrieveAllGroups() {
		return GroupMapper.INSTANCE.toGroupDTO(groupRepository.findAll());
	}

	public GroupDTO retrieveUser(int id) {
		return groupRepository.findById(id)
				.map(GroupMapper.INSTANCE::toGroupDTO)
				.orElseThrow(() -> new EntityNotFoundException("Group not Found with id: " + id));
	}

	public GroupDTO createGroup(GroupDTO groupDTO) {
		return GroupMapper.INSTANCE.toGroupDTO(groupRepository.save(GroupMapper.INSTANCE.fromGroupDTO(groupDTO)));
	}
}