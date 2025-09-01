package com.springboot.socialmedia.expection;

public class UserIsNotFoundExpection extends RuntimeException
{
    public UserIsNotFoundExpection(String message)
    {
        super(message);
    }
}
