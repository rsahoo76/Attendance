package com.cg.university.Attendance.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleDTO {


    private String name;
    private Boolean active;

    public RoleDTO(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

}
