package com.Application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Application.modals.Comment;
import com.Application.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(comment));
    }
}

