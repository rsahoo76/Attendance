//package com.cg.university.Attendance.controller;
//
//import com.cg.university.Attendance.entity.User;
//import com.cg.university.Attendance.repository.UserRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin( origins = "http://localhost:4200" )
//public class UserController {
//
//    private UserRepository userrepository;
//
//    @GetMapping("/users")
//    public List<User> getUsers(){
//        return userrepository.findAll();
//    }
//
//    @PostMapping("/users")
//    public void addUsers(@RequestBody User user){
//         userrepository.save(user);
//    }
//}
