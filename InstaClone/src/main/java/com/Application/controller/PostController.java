package com.Application.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Application.modals.Post;
import com.Application.service.PostService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/upload")
    public ResponseEntity<Post> createPost(
            @RequestParam("caption") String caption,
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") Long userId) throws IOException {

        Post post = postService.createPost(caption, file, userId);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}

