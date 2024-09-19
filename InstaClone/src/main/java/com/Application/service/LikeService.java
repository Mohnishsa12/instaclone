package com.Application.service;

import org.springframework.stereotype.Service;

import com.Application.modals.Like;
import com.Application.repository.LikeRepository;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Like likePost(Like like) {
        return likeRepository.save(like);
    }

    public void unlikePost(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
