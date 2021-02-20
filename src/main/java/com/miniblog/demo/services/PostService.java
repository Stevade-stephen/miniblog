package com.miniblog.demo.services;

import com.miniblog.demo.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    void newPost (Post post);

    Post fetchPost (Long postId);

    List<Post> fetchAllPosts();

    void updatePost (Post post, Long postId);

    void deletePost(Long postId);
}
