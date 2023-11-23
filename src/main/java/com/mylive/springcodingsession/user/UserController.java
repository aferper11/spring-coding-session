package com.mylive.springcodingsession.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> retrieveUser(@PathVariable("id") int id) {
		return userService.retrieveUser(id);
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
