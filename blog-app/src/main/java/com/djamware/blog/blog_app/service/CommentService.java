package com.djamware.blog.blog_app.service;

import com.djamware.blog.blog_app.model.Comment;

public interface CommentService {
    Comment save(Comment comment);
}