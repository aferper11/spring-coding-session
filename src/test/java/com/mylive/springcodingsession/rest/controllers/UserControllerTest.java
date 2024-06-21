package com.mylive.springcodingsession.rest.controllers;

import com.mylive.springcodingsession.domain.dtos.UserDTO;
import com.mylive.springcodingsession.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllUsers() {
        UserDTO user1 = createUserDTO(1);
        UserDTO user2 = createUserDTO(2);
        List<UserDTO> userList = Arrays.asList(user1, user2);

        when(userService.retrieveAllUsers()).thenReturn(userList);

        List<UserDTO> result = userController.retrieveAllUsers();

        assertEquals(2, result.size());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }

    @Test
    void testRetrieveUser() {
        int userId = 1;
        UserDTO user = createUserDTO(1);

        when(userService.retrieveUser(userId)).thenReturn(user);

        UserDTO result = userController.retrieveUser(userId);

        assertEquals(user, result);
    }

    @Test
    void testCreateUser() {
        UserDTO user = createUserDTO(1);

        when(userService.createUser(user)).thenReturn(user);

        ResponseEntity<UserDTO> response = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    private UserDTO createUserDTO(int id) {
        return new UserDTO(id, "Name " + id, LocalDate.now(), null);
    }
}
