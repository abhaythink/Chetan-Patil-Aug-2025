package com.thinkitive.springboot_rest_api.thinkitive_restful_web_services.socialMediaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class UserController
{

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService)
    {
        this.userDaoService=userDaoService;
    }
    @GetMapping("/users")
    public List<User> retriveAllUser()
    {
        return userDaoService.finAll();
    }
    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id)
    {
        return userDaoService.findUser(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User users)
    {
        return userDaoService.save(users);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id)
    {
        return userDaoService.deleteByUserId(id);
    }
}
