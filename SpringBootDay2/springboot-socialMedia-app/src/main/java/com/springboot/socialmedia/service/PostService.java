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

    public Optional<Post> findPostById(Long id)
    {
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


    public List<Post> findPostsByUserId(Long userId)    //find all post of user
    {
        if (!userRepo.existsById(userId)) {
            throw new UserIsNotFoundExpection("User with ID " + userId + " not found");
        }
        return postRepo.findByUserId(userId);
    }

    public Post findPostByUserIdAndPostId(Long userId,Long postId)
    {

        return postRepo.findByIdAndUserId(postId, userId)
                .orElseThrow(() -> new PostNotFoundException(
                        "Post with ID " + postId + " not found for User " + userId));

    }

    public Post updateUserPost(Long userId, Long postId, PostDto postDto)
    {
        //update post by user// they matches the post id and user id //
        Post post = postRepo.findByIdAndUserId(postId, userId)
                .orElseThrow(() -> new PostNotFoundException("Post not found for this user"));
        post.setContent(postDto.getContent());
        return postRepo.save(post);
    }

    public void deleteUserPost(Long userId, Long postId)
    {
        //delete post by perticular user...
        Post post = postRepo.findByIdAndUserId(postId, userId)
                .orElseThrow(() -> new PostNotFoundException("Post not found for this user"));
        postRepo.delete(post);
    }





}
