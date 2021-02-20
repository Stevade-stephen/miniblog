package com.miniblog.demo.services;

import com.miniblog.demo.models.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void newComment(Comment comment);

    Comment fetchComment (Long commentId);

    List<Comment> fetchAllComments();

    void deleteComment(Long commentId);
}
