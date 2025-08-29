package com.thinkitive.springboot.thinkitive_spring_boot_project.course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepository
{
    @Autowired
    private EntityManager entityManager;

    public void insert(Users user)
    {
        entityManager.merge(user);
    }

    public void selectById(int id)
    {
        entityManager.find(Users.class,id);
    }

    public void deleteById(Long id)
    {
        Users user=entityManager.find(Users.class,id);
        entityManager.remove(user);
    }

}
