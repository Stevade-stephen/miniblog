package com.miniblog.demo.services.serviceImpl;

import com.miniblog.demo.models.Post;
import com.miniblog.demo.repositories.PostRepository;
import com.miniblog.demo.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void newPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post fetchPost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (!post.isPresent()) {
            // Throw Error (Maybe?)
        }

        return post.get();
    }

    @Override
    public List<Post> fetchAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void updatePost(Post post, Long postId) {
        post.setId(postId);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
