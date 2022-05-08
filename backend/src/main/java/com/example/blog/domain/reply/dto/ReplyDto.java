package com.example.blog.domain.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public abstract class ReplyDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private String reply;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class CreateResponse {
        private Long id;
        private String reply;
        private LocalDateTime createdDate;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {
        private Long id;
        private String reply;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class UpdateResponse {
        private Long id;
        private String reply;
        private LocalDateTime lastModifiedDate;
    }
}
