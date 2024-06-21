package com.mylive.springcodingsession.domain.dtos;

import com.mylive.springcodingsession.domain.entities.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private LocalDate birthDate;
    private Group group;

    public UserDTO(String name, LocalDate birthDate) {
        super();
        this.name = name;
        this.birthDate = birthDate;
    }
}
