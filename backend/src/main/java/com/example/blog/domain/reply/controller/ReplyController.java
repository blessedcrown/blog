package com.example.blog.domain.reply.controller;

import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.reply.dto.ReplyDto;
import com.example.blog.domain.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping(value = "/api/reply")
@RestController
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping(value = "/{postId}")
    public ResponseEntity<?> create(@ModelAttribute ReplyDto.CreateRequest request, @PathVariable Long postId) {
        ReplyDto.CreateResponse response = replyService.create(request, postId);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/{postId}/{replyId}")
    public ResponseEntity<?> update(@ModelAttribute ReplyDto.UpdateRequest request,
                                    @PathVariable Long postId,
                                    @PathVariable Long replyId) {
        ReplyDto.UpdateResponse response = replyService.update(request, postId, replyId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{replyId}")
    public void delete(@PathVariable Long replyId) {
        replyService.delete(replyId);
    }

}
