package com.example.blog.domain.reply.service;

import com.example.blog.domain.reply.dto.ReplyDto;
import com.example.blog.domain.reply.dto.ReplyMapper;
import com.example.blog.domain.reply.entity.Reply;
import com.example.blog.domain.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;

    @Override
    public ReplyDto.CreateResponse create(ReplyDto.CreateRequest request) {
        Reply saved = replyRepository.save(replyMapper.toEntity(request));
        return replyMapper.toCreateResponse(saved);
    }

    @Override
    public ReplyDto.UpdateReponse update(ReplyDto.UpdateRequest request, Long id) {
        Reply found = replyRepository.findById(id).get();
        found.updateReply(request.getReply());
        return replyMapper.toUpdateResponse(found);
    }

    @Override
    public void delete(Long id) {
        Reply found = replyRepository.findById(id).get();
        replyRepository.delete(found);
    }
}
