package com.cg.university.Attendance.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="active")
    private Boolean active;


//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "roles")
    private Set<User> user =new HashSet<>();

    public Roles() {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
