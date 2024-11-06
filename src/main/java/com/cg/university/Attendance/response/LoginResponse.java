package com.cg.university.Attendance.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponse {
    String message;
    boolean status;

    public LoginResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
    public LoginResponse() {
    }

    public boolean isSuccess() {
        return status;
    }
}
