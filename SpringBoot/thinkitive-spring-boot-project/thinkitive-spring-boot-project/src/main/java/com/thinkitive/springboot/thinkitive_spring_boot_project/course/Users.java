package com.thinkitive.springboot.thinkitive_spring_boot_project.course;

import jakarta.persistence.*;
import org.apache.catalina.User;


@Entity
public class Users
{
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String  name;
    private String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users()
    {

    }
    public Users(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }


}
