package com.mylive.springcodingsession.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past
    private LocalDate birthDate;

    @ManyToOne
    private Group group;

    public User(String name, LocalDate birthDate) {
        super();
        this.name = name;
        this.birthDate = birthDate;
    }

    public User() {
    }

}
