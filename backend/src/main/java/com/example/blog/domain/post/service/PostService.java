package com.example.blog.domain.post.service;

import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    public PostDto.CreateResponse create(PostDto.CreateRequest request) throws Exception;

    public PostDto.DetailResponse findById(Long id);

    public Page<PostDto.DetailResponse> findAll(Pageable pageable);

    public PostDto.UpdateResponse update(PostDto.UpdateRequest request, Long id);

    public void delete(Long id);
}
