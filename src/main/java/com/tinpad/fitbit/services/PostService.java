package com.tinpad.fitbit.services;

import com.tinpad.fitbit.dto.PostDTO;
import com.tinpad.fitbit.entities.Image;
import com.tinpad.fitbit.entities.Post;
import com.tinpad.fitbit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts) {
            post.setTitleImage(new Image(post.getTitleImage().getName(), post.getTitleImage().getType(), ImageService.decompressBytes(post.getTitleImage().getImageByte())));
            postDTOs.add(new PostDTO(post));
        }
        return postDTOs;
    }

    public PostDTO getPostBySlug(String slug) {
        Post post = postRepository.findBySlug(slug).get();
        return new PostDTO(post);
    }

    public List<PostDTO> getPosts(String id) {
        if (id != null) {
            Post post = postRepository.findById(id).get();
            post.setTitleImage(new Image(post.getTitleImage().getName(), post.getTitleImage().getType(), ImageService.decompressBytes(post.getTitleImage().getImageByte())));
            return List.of(new PostDTO(post));
        }
        return getPosts();
    }

    public PostDTO addPost(PostDTO postDTO) {
        Post post = new Post(postDTO);
        post.setTitleImage(new Image(post.getTitleImage().getName(), post.getTitleImage().getType(), ImageService.compressBytes(post.getTitleImage().getImageByte())));
        postRepository.save(post);
        postDTO.setPostID(post.getPostID());
        return postDTO;
    }

    public PostDTO updatePost(PostDTO postDTO) {
        Post post = new Post(postDTO);
        post.setTitleImage(new Image(post.getTitleImage().getName(), post.getTitleImage().getType(), ImageService.compressBytes(post.getTitleImage().getImageByte())));
        postRepository.saveAndFlush(post);
        return postDTO;
    }

    public List<PostDTO> deletePosts() {
        List<PostDTO> postDTOs = getPosts();
        postRepository.deleteAll();
        return postDTOs;
    }

    public List<PostDTO> deletePosts(String id) {
        if(id != null) {
            List<PostDTO> postDTO = getPosts(id);
            postRepository.deleteById(id);
            return postDTO;
        }
        return deletePosts();
    }

}
