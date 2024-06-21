package com.mylive.springcodingsession.services;

import com.mylive.springcodingsession.domain.dtos.UserDTO;
import com.mylive.springcodingsession.domain.mappers.UserMapper;
import com.mylive.springcodingsession.repository.UserRepository;
import com.mylive.springcodingsession.rest.exceptions.EntityNotFoundException;
import com.mylive.springcodingsession.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> retrieveAllUsers() {
		return UserMapper.INSTANCE.toUserDTO(userRepository.findAll());
	}

	public UserDTO retrieveUser(int id) {
		return userRepository.findById(id)
				.map(UserMapper.INSTANCE::toUserDTO)
				.orElseThrow(() -> new EntityNotFoundException("User not Found with id: " + id));
	}

	public UserDTO createUser(UserDTO userDTO) {
		return UserMapper.INSTANCE.toUserDTO(userRepository.save(UserMapper.INSTANCE.fromUserDTO(userDTO)));
	}

	public UserDTO partialUpdateUser(UserDTO source, UserDTO target) {
		Utils.updateNonNullProperties(source, target);
		return UserMapper.INSTANCE.toUserDTO(userRepository.save(UserMapper.INSTANCE.fromUserDTO(target)));
	}
}