package com.cg.university.Attendance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name= "holidays")
@Getter
@Setter
public class Holidays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="date", columnDefinition = "DATE")
    private Date date;

    @Column(name="day_name")
    private String day;

    @Column(name="occasion")
    private String occasion;

}
