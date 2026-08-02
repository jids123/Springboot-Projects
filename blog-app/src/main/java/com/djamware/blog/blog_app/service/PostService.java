package com.djamware.blog.blog_app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.djamware.blog.blog_app.model.Post;

public interface PostService {
    Page<Post> list(String q, Pageable pageable);

    Optional<Post> get(Long id);

    Post save(Post post);

    void delete(Long id);
}