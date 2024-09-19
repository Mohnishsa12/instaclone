package com.Application.modals;

import jakarta.persistence.*;

import java.util.List;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Lob  // Large Object annotation to store large binary data
    private byte[] image;  // Image stored as binary

    private String caption;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;

    // Getters and setters
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Long postId, byte[] image, String caption, User user, List<Comment> comments, List<Like> likes) {
		super();
		this.postId = postId;
		this.image = image;
		this.caption = caption;
		this.user = user;
		this.comments = comments;
		this.likes = likes;
	}

    
}
