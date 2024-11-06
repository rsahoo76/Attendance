package com.cg.university.Attendance.service;

import com.cg.university.Attendance.dto.LoginDTO;
import com.cg.university.Attendance.entity.User;
import com.cg.university.Attendance.response.LoginResponse;
//import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService
{
    public List<User> findAll();
    LoginResponse loginUser(LoginDTO loginDTO);

}


