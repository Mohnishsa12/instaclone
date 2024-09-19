package com.Application.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Application.modals.Post;
import com.Application.repository.PostRepository;

import java.io.IOException;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(String caption, MultipartFile file, Long userId) throws IOException {
        Post post = new Post();
        post.setCaption(caption);
        post.setImage(file.getBytes());  // Convert file to byte array and set it

        // Here, you'll need to fetch the user by userId and set it
        // For simplicity, we're assuming userService is available to fetch user
        // User user = userService.getUserById(userId);
        // post.setUser(user);

        return postRepository.save(post);
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
