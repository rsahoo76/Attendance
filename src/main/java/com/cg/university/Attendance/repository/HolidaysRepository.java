package com.cg.university.Attendance.repository;

import com.cg.university.Attendance.entity.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4205")
@RepositoryRestResource(collectionResourceRel = "Holidays", path = "Holidays")
public interface HolidaysRepository extends JpaRepository<Holidays, Integer> {
    
}
