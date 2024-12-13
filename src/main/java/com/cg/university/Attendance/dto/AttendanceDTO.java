package com.cg.university.Attendance.dto;

import com.cg.university.Attendance.entity.Attendance;
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

    private String userName;

    public AttendanceDTO(Attendance attendance) {
        this.title = attendance.getTitle();
        this.start = attendance.getStart();
        this.end = attendance.getEnd();
        this.attended = attendance.getAttended();
        this.status = attendance.getStatus();
        this.userName = attendance.getUser_id().getFirstname() + " " + attendance.getUser_id().getLastname();
    }
}
