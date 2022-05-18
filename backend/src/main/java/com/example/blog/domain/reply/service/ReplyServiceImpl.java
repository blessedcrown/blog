package com.example.blog.domain.reply.service;

import com.example.blog.domain.post.entity.Post;
import com.example.blog.domain.post.repository.PostRepository;
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
    private final PostRepository postRepository;

    @Override
    public ReplyDto.CreateResponse create(ReplyDto.CreateRequest request, Long postId) {
        Post found = postRepository.findById(postId).get();
        Reply saved = replyRepository.save(replyMapper.toEntity(request));
        found.getReplies().add(saved);
        return replyMapper.toCreateResponse(saved);
    }

    @Override
    public ReplyDto.UpdateResponse update(ReplyDto.UpdateRequest request, Long postId, Long replyId) {
        Reply found = replyRepository.findById(replyId).get();
        found.updateReply(request.getReply());
        return replyMapper.toUpdateResponse(found);
    }

    @Override
    public void delete(Long replyId) {
        Reply found = replyRepository.findById(replyId).get();
        replyRepository.delete(found);
    }
}
