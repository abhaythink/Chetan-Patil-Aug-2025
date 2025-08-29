package com.thinkitive.springboot.thinkitive_spring_boot_project.SpringJpa;

import com.thinkitive.springboot.thinkitive_spring_boot_project.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepositoryUser extends JpaRepository<Users1,Long>
{
    List<Users1> findByEmail(String email);     //custom method
}
