package com.cg.university.Attendance.repository;

import com.cg.university.Attendance.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4205")
@RepositoryRestResource(collectionResourceRel = "Roles", path = "Roles")
public interface RolesRepository extends JpaRepository<Roles, Integer> {

     @Override
     Optional<Roles> findById(Integer integer);



     List<Roles> findAll();

}



