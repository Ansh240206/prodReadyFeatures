package com.project.prodReadyFeatures.Services;

import com.project.prodReadyFeatures.Dto.PostDto;
import com.project.prodReadyFeatures.Entities.PostEntity;
import com.project.prodReadyFeatures.Exceptions.ResourceNotFoundException;
import com.project.prodReadyFeatures.Repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {

        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);

        PostEntity createdEntity = postRepository.save(postEntity);

        return modelMapper.map(createdEntity, PostDto.class);

    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not Found with ID " + postId));
        return modelMapper.map(postEntity, PostDto.class);
    }
}
