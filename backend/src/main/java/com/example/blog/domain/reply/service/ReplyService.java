package com.example.blog.domain.reply.service;

import com.example.blog.domain.reply.dto.ReplyDto;

public interface ReplyService {

    public ReplyDto.CreateResponse create(ReplyDto.CreateRequest request);

    public ReplyDto.UpdateReponse update(ReplyDto.UpdateRequest request, Long id);

    public void delete(Long id);
}
