package com.Application.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Application.modals.Like;
import com.Application.service.LikeService;

@RestController
@RequestMapping("/posts/{postId}/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<Like> likePost(@RequestBody Like like) {
        return ResponseEntity.ok(likeService.likePost(like));
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> unlikePost(@PathVariable Long likeId) {
        likeService.unlikePost(likeId);
        return ResponseEntity.ok().build();
    }
}

