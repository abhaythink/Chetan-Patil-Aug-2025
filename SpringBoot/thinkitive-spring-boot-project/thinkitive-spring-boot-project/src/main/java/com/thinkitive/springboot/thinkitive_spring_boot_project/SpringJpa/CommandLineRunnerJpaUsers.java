package com.thinkitive.springboot.thinkitive_spring_boot_project.SpringJpa;

import com.thinkitive.springboot.thinkitive_spring_boot_project.course.UserRepository;
import com.thinkitive.springboot.thinkitive_spring_boot_project.course.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CommandLineRunnerJpaUsers implements CommandLineRunner {

    @Autowired
    SpringDataJpaRepositoryUser springDataJpaRepositoryUser;
    public void run(String... args) throws Exception
    {
        springDataJpaRepositoryUser.save(new Users1(1,"chetanprajput45@gmail.com","Chetan"));
        springDataJpaRepositoryUser.save(new Users1(2,"pallavi@gmail.com","Pallavi"));
        springDataJpaRepositoryUser.save(new Users1(3,"pratiksha@gmail.com","Pallavi"));
        springDataJpaRepositoryUser.deleteById(3l);
        System.out.println(springDataJpaRepositoryUser.findAll());

        System.out.println(springDataJpaRepositoryUser.findByEmail("pallavi@gmail.com"));

    }
}
