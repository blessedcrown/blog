package com.example.blog.domain.reply.dto;

import com.example.blog.domain.reply.entity.Reply;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {

    public Reply toEntity(ReplyDto.CreateRequest request) {
        return Reply.builder()
                .reply(request.getReply()).build();
    }

    public ReplyDto.CreateResponse toCreateResponse(Reply reply) {
        return ReplyDto.CreateResponse.builder()
                .id(reply.getId())
                .reply(reply.getReply())
                .createdDate(reply.getCreatedDate())
                .build();
    }

    public ReplyDto.UpdateResponse toUpdateResponse(Reply reply) {
        return ReplyDto.UpdateResponse.builder()
                .id(reply.getId())
                .reply(reply.getReply())
                .lastModifiedDate(reply.getLastModifiedDate())
                .build();
    }
}
