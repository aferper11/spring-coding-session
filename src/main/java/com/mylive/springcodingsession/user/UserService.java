package com.mylive.springcodingsession.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> retrieveUser(int id) {
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not Found with id: "+id);
		}
		
		return user;
	}

	public ResponseEntity<User> createUser(User user) {
		userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}