
package com.example.socialmedia.controller;

import com.example.socialmedia.entity.Post;
import com.example.socialmedia.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts";
    }

    @GetMapping("/posts/new")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/posts")
    public String savePost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }
}
