package com.mylive.springcodingsession.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "group_table")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "Group name cannot be null")
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }



}
