package com.flexiteam.flexiteam.dtos.User;


import com.flexiteam.flexiteam.entities.Employee;

public class UserDto {
    Long id;
    String username;
    String email;
    String password;
    Long employeeId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getId() {
        return id;
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


    public UserDto(Long id, String username, String email, String password,Long employeeId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.employeeId=employeeId;
    }
}
