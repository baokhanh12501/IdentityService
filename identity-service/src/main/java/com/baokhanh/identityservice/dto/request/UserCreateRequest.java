package com.baokhanh.identityservice.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreateRequest {
    @Size(min = 3,max = 12 ,message = "Username must be at least 3 characters and most 12 characters")
    private String username;

    @Size(min = 8,message = "Password must be at least 8 characters")
    private String password;
    private String fistName;
    private String lastName;
    private LocalDate dob;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
