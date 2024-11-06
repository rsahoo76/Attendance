package com.cg.university.Attendance.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class HolidaysDTO {

    private Date date;

    private String day;

    private String occasion;
}
