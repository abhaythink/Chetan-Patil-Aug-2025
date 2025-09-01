package com.springboot.socialmedia.expection;

public class UserAlreadyExistsException extends RuntimeException
{
    public UserAlreadyExistsException(String message)
    {
       super(message);
    }

}
