package com.djamware.blog.blog_app.controller;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.djamware.blog.blog_app.model.Post;
import com.djamware.blog.blog_app.service.PostService;

@Controller
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    // List all posts
    @GetMapping("/")
    public String viewHomePage(Model model) {
        Pageable pageable = PageRequest.of(0, 10);
        model.addAttribute("posts", postService.list("", pageable));
        return "index";
    }

    // View post details
    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.get(id);
        if (post.isPresent()){
            model.addAttribute("post", post.get());
        return "post";
        }
        else{
            return "error";
        }
    }
}