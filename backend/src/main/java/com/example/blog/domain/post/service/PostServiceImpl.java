package com.example.blog.domain.post.service;

import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.post.dto.PostMapper;
import com.example.blog.domain.post.entity.Post;
import com.example.blog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostDto.CreateResponse create(PostDto.CreateRequest request) {
        Post saved = postRepository.save(postMapper.toEntity(request));
        return postMapper.toCreateResponse(saved);
    }

    @Override
    public PostDto.DetailResponse findById(Long id) {
        Post found = postRepository.findById(id).get();
        return postMapper.toDetailResponse(found);
    }

    @Override
    public Page<PostDto.DetailResponse> findAll(Pageable pageable) {
        return postRepository.findAllByOrderByIdDesc(pageable).map(PostMapper::toDetailResponse);
    }

    @Override
    public PostDto.UpdateResponse update(PostDto.UpdateRequest request, Long id) {
        Post found = postRepository.findById(id).get();
        found.updateTitle(request.getTitle());
        found.updateContent(request.getContent());
        //TODO 사진 수정 로직 추가 해야됨
        return postMapper.toUpdateResponse(found);
    }

    @Override
    public void delete(Long id) {
        Post toDelete = postRepository.findById(id).get();
        postRepository.delete(toDelete);
    }
}
