package com.springboot.socialmedia.repository;

import com.springboot.socialmedia.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post,Long>
{
    List<Post> findByUserId(Long userId);
    Optional<Post> findByIdAndUserId(Long postId, Long userId);

}
