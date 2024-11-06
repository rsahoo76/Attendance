package com.cg.university.Attendance.service;

import com.cg.university.Attendance.entity.Department;
import com.cg.university.Attendance.repository.DepartmentRepository;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments(Department[] department) ;
}
