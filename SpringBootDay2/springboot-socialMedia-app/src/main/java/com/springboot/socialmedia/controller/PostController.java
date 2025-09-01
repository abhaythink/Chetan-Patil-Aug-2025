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
@RequestMapping
public class PostController
{
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/post/{id}")
    public Optional<Post> findPostById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Post> addPost(@Valid @RequestBody PostDto postDto) {
        Post addedPost = postService.addPost(postDto);
        return ResponseEntity.status(201).body(addedPost);
    }


    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        Post updatedPost = postService.updatePost(id, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
