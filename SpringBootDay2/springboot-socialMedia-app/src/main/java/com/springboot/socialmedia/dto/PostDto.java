package com.springboot.socialmedia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PostDto
{
    @NotBlank(message = "Content should not blank or empty")
    private String content;
    //@NotBlank(message = "User Id Should not black")
    @NotNull(message = "User Id should not be null")
    @Positive(message = "User Id should be greater than 0")
    private Long userId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
