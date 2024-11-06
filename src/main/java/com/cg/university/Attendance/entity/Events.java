package com.cg.university.Attendance.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
//@Table(name= "Events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //    @Column(name = "title")
    private String title;

    //    @Column(name = "starttime")
    private String startTime;

    //    @Column(name = "endtime")
    private String endTime;


}

