package com.flexiteam.flexiteam.dtos.User;

import com.flexiteam.flexiteam.entities.Employee;

public class CreateUserDto {
    String username;
    String email;
    String password;
    Long employeeId;

    public CreateUserDto(String username, String email, String password, Long employeeId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
