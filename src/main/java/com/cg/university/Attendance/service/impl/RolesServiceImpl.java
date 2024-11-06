package com.cg.university.Attendance.service.impl;

import com.cg.university.Attendance.entity.Roles;
import com.cg.university.Attendance.repository.RolesRepository;

import java.util.List;

public class RolesServiceImpl {

    private final RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    List<Roles> getAllRoles(Roles[] roles) {
        return rolesRepository.findAll();
    }

}


