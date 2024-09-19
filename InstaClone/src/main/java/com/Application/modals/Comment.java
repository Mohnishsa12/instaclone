package com.Application.modals;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 1000)
    private String commentText;

    @Column(nullable = false)
    private java.time.LocalDateTime commentedAt;

    // Getters and Setters
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public java.time.LocalDateTime getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(java.time.LocalDateTime commentedAt) {
		this.commentedAt = commentedAt;
	}

	public Comment(Long commentId, Post post, User user, String commentText, LocalDateTime commentedAt) {
		super();
		this.commentId = commentId;
		this.post = post;
		this.user = user;
		this.commentText = commentText;
		this.commentedAt = commentedAt;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
