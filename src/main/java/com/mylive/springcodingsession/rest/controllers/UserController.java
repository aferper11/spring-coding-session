package com.mylive.springcodingsession.rest.controllers;

import com.mylive.springcodingsession.domain.dtos.UserDTO;
import com.mylive.springcodingsession.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = "application/json")
    public List<UserDTO> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    @GetMapping(value = "/user/{id}", produces = "application/json")
    public UserDTO retrieveUser(@PathVariable("id") int id) {
        return userService.retrieveUser(id);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/user/{id}")
    public ResponseEntity<UserDTO> partialUpdateUser(@PathVariable(value = "id") int id, @RequestBody UserDTO userDTO) {
        UserDTO userFound = userService.retrieveUser(id);
        return new ResponseEntity<>(userService.partialUpdateUser(userDTO, userFound), HttpStatus.CREATED);
    }
}
