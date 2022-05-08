package com.example.blog.domain.post.service;

import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    public PostDto.CreateResponse create(PostDto.CreateRequest request);

    public PostDto.DetailResponse findById(Long id);

    public Page<PostDto.DetailResponse> findAll(Pageable pageable);

    public PostDto.UpdateResponse update(PostDto.UpdateRequest request, Long id);

    public void delete(Long id);
}
