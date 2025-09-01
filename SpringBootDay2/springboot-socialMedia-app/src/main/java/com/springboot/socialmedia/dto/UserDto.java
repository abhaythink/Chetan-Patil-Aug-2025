package com.springboot.socialmedia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto
{

    @NotBlank(message = "Name filed should not be blank")
    private String username;

    @Email(message = "Enter the Valid Email")
    @NotBlank(message = "Email should to be empty")

    private String email;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
