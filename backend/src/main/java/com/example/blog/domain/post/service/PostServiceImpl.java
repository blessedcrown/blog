package com.example.blog.domain.post.service;

import com.example.blog.domain.picture.entity.Picture;
import com.example.blog.domain.picture.repository.PictureRepository;
import com.example.blog.domain.picture.service.PictureHandler;
import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.post.dto.PostMapper;
import com.example.blog.domain.post.entity.Post;
import com.example.blog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final PictureHandler pictureHandler;
    private final PictureRepository pictureRepository;
    @Override
    public PostDto.CreateResponse create(PostDto.CreateRequest request) throws Exception {
        Post saved = postRepository.save(postMapper.toEntity(request));

        List<Picture> picList = pictureHandler.parsePictureInfo(request.getMultipartFiles());
        if(picList.isEmpty()) {

        }
        else {
            //List<Picture> pictureBeans = new ArrayList<>();
            for(Picture pic : picList) {
                saved.getPictures().add(pictureRepository.save(pic));
            }
            //saved.setPictures(pictureBeans);
        }
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
