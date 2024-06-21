package com.mylive.springcodingsession.rest.controllers;

import com.mylive.springcodingsession.domain.dtos.GroupDTO;
import com.mylive.springcodingsession.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping(value = "/groups", produces = "application/json")
    public List<GroupDTO> retrieveAllGroups() {
        return groupService.retrieveAllGroups();
    }

    @GetMapping(value = "/group/{id}", produces = "application/json")
    public GroupDTO retrieveGroup(@PathVariable("id") int id) {
        return groupService.retrieveUser(id);
    }

    @PostMapping("/groups")
    public ResponseEntity<GroupDTO> createGroup(@RequestBody @Valid GroupDTO groupDTO) {
        return new ResponseEntity<>(groupService.createGroup(groupDTO), HttpStatus.CREATED);
    }

}
