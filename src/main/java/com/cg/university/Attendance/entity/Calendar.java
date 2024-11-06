package com.cg.university.Attendance.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="calendar_1")
@Getter
@Setter
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="semester")
    private Integer semester;

    @Column(name="calendar_date", columnDefinition = "DATE")
//    @Timestamp
    private Date date;

    @Column(name="day_name")
    private String day;

    @Column(name="slot1")
    private String slot1;

    @Column(name="slot2")
    private String slot2;

    @Column(name="slot3")
    private String slot3;

    @Column(name="slot4")
    private String slot4;

    @Column(name="slot5")
    private String slot5;

    @Column(name="slot6")
    private String slot6;

    @Column(name="slot7")
    private String slot7;

    @Column(name="slot8")
    private String slot8;


}
