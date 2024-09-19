package com.Application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Application.modals.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Add custom queries if needed
}

