package com.cg.university.Attendance.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CalendarDTO {

    private Integer semester;
    private Date date;
    private String day;
    private String slot1;
    private String slot2;
    private String slot3;
    private String slot4;
    private String slot5;

    private String slot6;

    private String slot7;

    private String slot8;

}
