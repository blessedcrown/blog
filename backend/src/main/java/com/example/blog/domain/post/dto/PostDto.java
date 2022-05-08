package com.example.blog.domain.post.dto;

import com.example.blog.domain.like.entity.Likes;
import com.example.blog.domain.picture.entity.Picture;
import com.example.blog.domain.reply.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

public abstract class PostDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private String title;
        private String content;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class CreateResponse {
        private Long id;
        private String title;
        private String content;
        private List<Picture> pictures;
        private LocalDateTime createdDate;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {
        private Long id;
        private String title;
        private String content;
        private List<Picture> pictures;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class UpdateResponse {
        private Long id;
        private String title;
        private String content;
        private List<Picture> pictures;
        private List<Reply> replies;
        private List<Likes> likes;
        private LocalDateTime lastModifiedDate;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class DetailResponse {
        private Long id;
        private String title;
        private String content;
        private List<Picture> pictures;
        private List<Reply> replies;
        private List<Likes> likes;
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;
    }
}
