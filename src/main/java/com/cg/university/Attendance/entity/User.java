package com.cg.university.Attendance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "user")
@Getter     //lombok will write getter & setter for us in the back
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "firstname")
    private String firstname;

    @Column(name= "lastname")
    private String lastname;

    @Column(name= "email")
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name= "phone_number")
    private String phoneNumber;

    @Column(name= "location")
    private String location;

    @Column(name= "attended")
    private Boolean attended;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

      @ManyToOne
      @JoinColumn(name = "role_id", referencedColumnName = "id")
      private Roles roles;


//    public User(String userName, String password) {
//    }
}

