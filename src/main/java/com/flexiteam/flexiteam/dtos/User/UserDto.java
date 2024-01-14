package com.flexiteam.flexiteam.dtos.User;


public class UserDto {
    Long id;
    String username;
    String email;
    String password;

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


    public UserDto(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
