package com.flexiteam.flexiteam.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserGroup {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    private String userGroup;

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }
}
