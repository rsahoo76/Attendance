package com.cg.university.Attendance.repository;

import com.cg.university.Attendance.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4205")
@RepositoryRestResource(collectionResourceRel = "Department", path = "Department")
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Override
    Optional<Department> findById(Integer integer);

    List<Department> findAll();


}
