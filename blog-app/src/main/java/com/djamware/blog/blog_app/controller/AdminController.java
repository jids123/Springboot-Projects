package com.djamware.blog.blog_app.controller;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djamware.blog.blog_app.model.Post;
import com.djamware.blog.blog_app.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PostService postService;

    public AdminController(PostService postService) {
        this.postService = postService;
    }

    // List posts for admin
    @GetMapping("/posts")
    public String listPosts(Model model) {
        Pageable pageable = PageRequest.of(0, 10);
        model.addAttribute("posts", postService.list("", pageable));
        return "admin/posts";
    }

    // Show form to create a new post
    @GetMapping("/posts/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "admin/create_post";
    }

    // Save new post
    @PostMapping("/posts")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.save(post);
        return "redirect:/admin/posts";
    }

    // Show form to edit an existing post
    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.get(id);
        if (post.isPresent()){
            model.addAttribute("post", post.get());
        return "admin/edit_post";
        }
        else{
            return "error";
        }
/*        model.addAttribute("post", postService.get(id));*/
    }

    // Update post
    @PostMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute("post") Post post) {
        Optional<Post> existingPost = postService.get(id);
        existingPost.get().setTitle(post.getTitle());
        existingPost.get().setContent(post.getContent());
        postService.save(existingPost.get());
        return "redirect:/admin/posts";
    }

    // Delete post
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/admin/posts";
    }
}