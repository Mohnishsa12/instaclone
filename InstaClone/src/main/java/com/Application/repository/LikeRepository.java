package com.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Application.modals.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
    // Add custom queries if needed
}
