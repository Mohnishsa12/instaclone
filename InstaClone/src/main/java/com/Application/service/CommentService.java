package com.Application.service;
import org.springframework.stereotype.Service;
import com.Application.modals.Comment;
import com.Application.repository.CommentRepository;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findAll();  // Customize query if needed
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
}

