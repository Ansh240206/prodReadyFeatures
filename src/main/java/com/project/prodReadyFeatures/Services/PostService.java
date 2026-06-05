package com.project.prodReadyFeatures.Services;

import com.project.prodReadyFeatures.Dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);
}
