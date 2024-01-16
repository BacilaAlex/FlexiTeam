package com.flexiteam.flexiteam.dtos.User;


import com.flexiteam.flexiteam.entities.Employee;

public class UserDto {
    Long id;
    String username;
    String email;
    String password;
    Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }


    public UserDto(Long id, String username, String email, String password, Employee employee) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.employee = employee;
    }
}
