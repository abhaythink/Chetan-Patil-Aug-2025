package com.springboot.socialmedia.controller;

import com.springboot.socialmedia.dto.PostDto;
import com.springboot.socialmedia.entity.Post;
import com.springboot.socialmedia.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/posts")
public class PostController
{
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{postId}")
    public Optional<Post> findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping
    public ResponseEntity<Post> addPost(@Valid @RequestBody PostDto postDto) {
        Post addedPost = postService.addPost(postDto);
        return ResponseEntity.status(201).body(addedPost);
    }


    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        Post updatedPost = postService.updatePost(id, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/posts")       //get all the post of particular user
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId)
    {
        List<Post> posts = postService.findPostsByUserId(userId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public ResponseEntity<Post> getUserPostById(@PathVariable Long userId, @PathVariable Long postId) {
        Post post = postService.findPostByUserIdAndPostId(userId, postId);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{userId}/posts/{postId}")
    public ResponseEntity<Post> updateUserPost( @PathVariable Long userId,@PathVariable Long postId,@RequestBody PostDto postDto) {

        Post updatedPost = postService.updateUserPost(userId, postId, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{userId}/posts/{postId}")
    public ResponseEntity<Void> deleteUserPost(@PathVariable Long userId,@PathVariable Long postId)
    {
        postService.deleteUserPost(userId, postId);
        return ResponseEntity.noContent().build();
    }







}
