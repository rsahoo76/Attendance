package com.cg.university.Attendance.dto;

import com.cg.university.Attendance.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class AttendanceDTO {
    private String title;

    private String userEmail;

    private Date start;

    private Date end;

    private Boolean attended;

    private String notes;

    private String status;
}
