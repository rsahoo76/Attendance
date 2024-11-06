package com.cg.university.Attendance.repository;

import com.cg.university.Attendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4205")
@RepositoryRestResource(collectionResourceRel = "attendance", path = "attendance")
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    @Override
    Optional<Attendance> findById(Integer integer);

    @Override
    List<Attendance> findAll();

    Optional<Attendance> findByTitleAndStartAndEnd(String title, Date start, Date end);

}
