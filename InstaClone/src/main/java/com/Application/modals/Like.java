package com.Application.modals;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private java.time.LocalDateTime likedAt;

    // Getters and Setters
	public Long getLikeId() {
		return likeId;
	}

	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public java.time.LocalDateTime getLikedAt() {
		return likedAt;
	}

	public void setLikedAt(java.time.LocalDateTime likedAt) {
		this.likedAt = likedAt;
	}

	public Like(Long likeId, User user, Post post, LocalDateTime likedAt) {
		super();
		this.likeId = likeId;
		this.user = user;
		this.post = post;
		this.likedAt = likedAt;
	}

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}

