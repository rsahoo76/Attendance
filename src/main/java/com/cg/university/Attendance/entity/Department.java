package com.cg.university.Attendance.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    private Set<User> user =new HashSet<>();


    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
