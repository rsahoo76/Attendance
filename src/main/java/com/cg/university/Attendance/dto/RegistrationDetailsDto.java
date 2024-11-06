package com.cg.university.Attendance.dto;

import com.cg.university.Attendance.entity.Department;
import com.cg.university.Attendance.entity.Roles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class RegistrationDetailsDto {
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private String phoneNumber;
        private String location;
        private Boolean attended;
        private String department;
        private String roles;

//        private Department department;
//        private Roles roles;

//        private DepartmentDTO department;
//        //private Set<RoleDTO> roles;
//        private RoleDTO roles;
}
