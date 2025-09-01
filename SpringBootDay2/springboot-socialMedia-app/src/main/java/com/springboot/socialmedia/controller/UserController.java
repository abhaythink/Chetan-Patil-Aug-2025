package com.springboot.socialmedia.controller;

import com.springboot.socialmedia.dto.UserDto;
import com.springboot.socialmedia.entity.User;
import com.springboot.socialmedia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController
{

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser()
    {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable Long id)
    {
        Optional<User> user = userService.findUserById(id);

        return ResponseEntity.ok(user);
//            return userService.findUserById(id)
//                    .map(ResponseEntity::ok)//200
//                    .orElse(ResponseEntity.notFound().build()); //404
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDto userDto)
    {
        User addedUser = userService.addUser(userDto);
        return ResponseEntity.status(201).body(addedUser);


    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto)
    {
        User updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }





}
