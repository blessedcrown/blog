package com.example.blog.domain.post.dto;

import com.example.blog.domain.post.entity.Post;

public class PostMapper {

    public Post toEntity(PostDto.CreateRequest request) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .pictureId(request.getPictureId())
                .build();
    }

    public Post toEntity(PostDto.UpdateRequest request) {
        return Post.builder()
                .id(request.getId())
                .title(request.getTitle())
                .content(request.getContent())
                .pictureId(request.getPictureId()).build();
    }

    public PostDto.CreateResponse toCreateResponse(Post post) {
        return PostDto.CreateResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .pictureId(post.getPictureId())
                .build();
    }

    public PostDto.DetailResponse toDetailResponse(Post post) {
        return PostDto.DetailResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .pictureId(post.getPictureId())
                .replies(post.getReplies())
                .likes(post.getLikes())
                .createdDate(post.getCreatedDate())
                .lastModifiedDate(post.getLastModifiedDate())
                .build();
    }

    public PostDto.UpdateResponse toUpdateResponse(Post post) {
        return PostDto.UpdateResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .pictureId(post.getPictureId())
                .replies(post.getReplies())
                .likes(post.getLikes())
                .lastModifiedDate(post.getLastModifiedDate())
                .build();
    }
}
