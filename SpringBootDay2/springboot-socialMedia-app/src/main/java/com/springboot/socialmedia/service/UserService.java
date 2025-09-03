package com.springboot.socialmedia.service;


import com.springboot.socialmedia.dto.UserDto;
import com.springboot.socialmedia.entity.User;
import com.springboot.socialmedia.expection.UserAlreadyExistsException;
import com.springboot.socialmedia.expection.UserIsNotFoundExpection;
import com.springboot.socialmedia.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public List<User> getAllUser()
    {
        List<User> userList=new ArrayList<User>();
        userList=userRepo.findAll();
        return userList;
    }

    public Optional<User> findUserById(Long id)
    {
        Optional<User> user=userRepo.findById(id);
        if(user.isEmpty())
        {
            throw new UserIsNotFoundExpection("User is not Found");
        }

        return user;
    }

    public User addUser(UserDto userDto)
    {

        User user=userRepo.findByEmail(userDto.getEmail());
        if(user==null)
        {
            User userAdd=new User();
            userAdd.setName(userDto.getUsername());
            userAdd.setEmail(userDto.getEmail());

            userRepo.save(userAdd);
            return userAdd;
        }
        else
        {
            throw new UserAlreadyExistsException("User Already Exists ");
        }


    }
    public User updateUser(Long id,UserDto userDto)
    {
       Optional<User> user=userRepo.findById(id);

       if(user.isEmpty())
       {
           throw new UserIsNotFoundExpection("User is not Found");
       }

       User existingUser = user.get();
       existingUser.setName(userDto.getUsername());
       existingUser.setEmail(userDto.getEmail());

       userRepo.save(existingUser);
        return existingUser;

    }

    public void deleteUser(Long id)
    {
        //Optional<User> user=userRepo.findById(id);

        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserIsNotFoundExpection("User with ID " + id + " not found"));
        userRepo.delete(user);
    }




}
