package com.cg.university.Attendance.controller;

import com.cg.university.Attendance.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {


    private DepartmentRepository departmentRepository;

//    public DepartmentController(departmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }
//
//    @GetMapping("/department")
//    public List<Department> getDepartments() {
//        return (List<Department>) departmentRepository.findAll();
//    }

}

