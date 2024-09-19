package com.Application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Application.modals.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Add custom queries if needed
}

