package com.thinkitive.springboot.thinkitive_spring_boot_project.course;

import com.thinkitive.springboot.thinkitive_spring_boot_project.course.jdbc.JdbcCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLIneRunnerJdbcUser implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception
    {
        userRepository.insert(new Users(1,"chetanprajput45@gmail.com","Chetan"));
        userRepository.insert(new Users(2,"Pallavi@gmail.com","pallavi"));


       // userRepository.deleteByeId(3);

        userRepository.selectById(1);

        // System.out.println(jdbcCourseRepository.selectById(1));

    }

}
