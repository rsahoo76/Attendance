package com.cg.university.Attendance.service.impl;

import com.cg.university.Attendance.entity.Department;
import com.cg.university.Attendance.repository.DepartmentRepository;
import com.cg.university.Attendance.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    DepartmentServiceImpl(DepartmentRepository departmentRepository){ }

    public List<Department> getAllDepartments(Department[] department) {

        return departmentRepository.findAll();
    }
}
