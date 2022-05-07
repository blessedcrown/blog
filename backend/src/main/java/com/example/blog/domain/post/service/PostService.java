package com.example.blog.domain.post.service;

import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.post.entity.Post;

public interface PostService {
    public PostDto.CreateResponse create(PostDto.CreateRequest request);

    public PostDto.DetailResponse findById(Long id);

    public PostDto.UpdateResponse update(PostDto.UpdateRequest request, Long id);

    public void delete(Long id);
}
