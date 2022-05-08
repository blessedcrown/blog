package com.example.blog.domain.reply.service;

import com.example.blog.domain.reply.dto.ReplyDto;

public interface ReplyService {

    public ReplyDto.CreateResponse create(ReplyDto.CreateRequest request, Long postId);

    public ReplyDto.UpdateReponse update(ReplyDto.UpdateRequest request, Long postId, Long replyId);

    public void delete(Long replyId);
}
