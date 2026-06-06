package com.project.prodReadyFeatures.Controllers;

import com.project.prodReadyFeatures.Dto.PostDto;
import com.project.prodReadyFeatures.Services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){

        return postService.getAllPosts();

    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId){

        return postService.getPostById(postId);

    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto input){

        return postService.createNewPost(input);

    }

    @PutMapping("/{postId}")
    public PostDto updatePostById(@RequestBody PostDto updatedInput, @PathVariable Long postId){

        return postService.updatePostById(updatedInput, postId);

    }

}
