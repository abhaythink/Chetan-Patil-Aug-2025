package com.thinkitive.springboot.thinkitive_spring_boot_project.SpringJpa;

import jakarta.persistence.*;


@Entity
public class Users1
{
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
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

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users1() {

    }

    public Users1(long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course [id= "+id+", name= "+name+", email="+email+ " ]";
    }
}