package com.djamware.blog.blog_app.service;

import org.springframework.stereotype.Service;

import com.djamware.blog.blog_app.model.Comment;
import com.djamware.blog.blog_app.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}