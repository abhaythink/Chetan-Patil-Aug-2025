package com.springboot.socialmedia.expection;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String message)
    {
        super(message);
    }
}
