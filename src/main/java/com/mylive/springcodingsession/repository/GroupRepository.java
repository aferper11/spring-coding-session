package com.mylive.springcodingsession.repository;

import com.mylive.springcodingsession.domain.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}
