package com.miniblog.demo.services.serviceImpl;

import com.miniblog.demo.models.Comment;
import com.miniblog.demo.repositories.CommentRepository;
import com.miniblog.demo.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void newComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment fetchComment(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (!comment.isPresent()) {
           // Do something
        }

        return comment.get();
    }

    @Override
    public List<Comment> fetchAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
