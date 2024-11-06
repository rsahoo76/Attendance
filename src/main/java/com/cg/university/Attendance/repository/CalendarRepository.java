package com.cg.university.Attendance.repository;

import com.cg.university.Attendance.entity.Calendar;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4205")
@RepositoryRestResource(collectionResourceRel = "calendar_1", path = "calendar_1")
public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

//    @Override
//    List<Calendar> findAll();

//    public List<Calendar> findAllevents();
    @Override
    Optional<Calendar> findById(Integer integer);

    @Override
    List<Calendar> findAll();


}
