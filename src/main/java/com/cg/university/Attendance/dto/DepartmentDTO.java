package com.cg.university.Attendance.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentDTO {

    private String name;

    public DepartmentDTO(String name) {
        this.name = name;
    }
}
