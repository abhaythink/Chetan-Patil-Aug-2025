package com.thinkitive.springboot.thinkitive_spring_boot_project.course.jdbc;

import com.thinkitive.springboot.thinkitive_spring_boot_project.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerJdbcCourse implements CommandLineRunner  //commandLineRunner runs your code automatically after Spring Boot start
{

    @Autowired
    private JdbcCourseRepository jdbcCourseRepository;
    @Override
    public void run(String... args) throws Exception
    {
        jdbcCourseRepository.insert(new Course(1,"Spring-boot-think","Chetan"));
        jdbcCourseRepository.insert(new Course(2,"Spring-boot-think","Pallavi"));
        jdbcCourseRepository.insert(new Course(3,"Spring-boot-think","Pratiksha"));

        jdbcCourseRepository.deleteByeId(3);

        jdbcCourseRepository.selectById(1);

        System.out.println(jdbcCourseRepository.selectById(1));

    }
}
