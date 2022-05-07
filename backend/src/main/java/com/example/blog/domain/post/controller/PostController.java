package com.example.blog.domain.post.controller;

import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping(value = "/api/post")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute PostDto.CreateRequest request) {
        PostDto.CreateResponse response = postService.create(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        PostDto.DetailResponse response = postService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @ModelAttribute PostDto.UpdateRequest request) {
        PostDto.UpdateResponse response = postService.update(request, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }

    @GetMapping
    public ResponseEntity<?> paginate(Pageable pageable) {
        Page<PostDto.DetailResponse> page = postService.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }
}
