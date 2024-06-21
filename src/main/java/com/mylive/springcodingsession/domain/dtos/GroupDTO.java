package com.mylive.springcodingsession.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {

    private Integer id;
    @NotNull(message = "Group name cannot be null")
    private String groupName;

    public GroupDTO(String groupName) {
        this.groupName = groupName;
    }
}
