package com.tinpad.fitbit.controllers;

import com.tinpad.fitbit.dto.PostDTO;
import com.tinpad.fitbit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> getPosts(@RequestParam(name = "id", required = false) String id) {
        return postService.getPosts(id);
    }

    @GetMapping("/slug")
    public PostDTO getPostBySlug(@RequestParam(name = "slug") String slug) {
        return postService.getPostBySlug(slug);
    }

    @PostMapping
    public PostDTO addPost(@RequestBody PostDTO postDTO) {
        return postService.addPost(postDTO);
    }

    @PutMapping
    public PostDTO updatePost(@RequestBody PostDTO postDTO) {
        return postService.updatePost(postDTO);
    }

    @DeleteMapping
    public List<PostDTO> deletePosts(@RequestParam(name = "id", required = false) String id) {
        return postService.deletePosts(id);
    }

}
