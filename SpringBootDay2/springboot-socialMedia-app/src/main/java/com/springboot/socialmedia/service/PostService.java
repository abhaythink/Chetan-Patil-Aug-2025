package com.springboot.socialmedia.service;

import com.springboot.socialmedia.dto.PostDto;
import com.springboot.socialmedia.entity.Post;
import com.springboot.socialmedia.entity.User;
import com.springboot.socialmedia.expection.PostNotFoundException;
import com.springboot.socialmedia.expection.UserIsNotFoundExpection;
import com.springboot.socialmedia.repository.PostRepo;
import com.springboot.socialmedia.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService
{
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public PostService(PostRepo postRepo, UserRepo userRepo)
    {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Optional<Post> findPostById(Long id) {
        return postRepo.findById(id);
    }

    public Post addPost(PostDto postDto) {
        User user = userRepo.findById(postDto.getUserId())
                .orElseThrow(() -> new UserIsNotFoundExpection("User not found"));

        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setUser(user);
        return postRepo.save(post);
    }

    public Post updatePost(Long id, PostDto postDto) {
        Post existingPost = postRepo.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post is not found"));

        existingPost.setContent(postDto.getContent());
        return postRepo.save(existingPost);
    }

    public void deletePost(Long id)
    {
        if (!postRepo.existsById(id))
        {
            throw new PostNotFoundException("Post is not found");
        }
        postRepo.deleteById(id);
    }




}
