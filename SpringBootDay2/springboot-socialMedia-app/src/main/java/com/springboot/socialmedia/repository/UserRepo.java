package com.springboot.socialmedia.repository;

import com.springboot.socialmedia.entity.Post;
import com.springboot.socialmedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long>
{
        User findByEmail(String email);
}
