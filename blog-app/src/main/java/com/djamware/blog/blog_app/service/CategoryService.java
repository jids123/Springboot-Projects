package com.djamware.blog.blog_app.service;

import java.util.List;
import java.util.Optional;

import com.djamware.blog.blog_app.model.Category;

public interface CategoryService {
    List<Category> list();

    Optional<Category> get(Long id);

    Category save(Category category);

    void delete(Long id);
}