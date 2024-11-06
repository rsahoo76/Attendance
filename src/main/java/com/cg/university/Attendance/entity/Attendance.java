package com.cg.university.Attendance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name= "attendance")
@Getter
@Setter
@ToString
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @Column(name= "start_time")
    private Date start;

    @Column(name= "end_time")
    private Date end;

    @Column(name= "attended")
    private Boolean attended;

    @Column(name= "notes")
    private String notes;

    @Column(name= "status")
    private String status;
}
