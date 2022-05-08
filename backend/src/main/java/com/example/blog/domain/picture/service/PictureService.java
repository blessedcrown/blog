package com.example.blog.domain.picture.service;

import com.example.blog.domain.picture.dto.PictureDto;

public interface PictureService {
    public Long saveFile(PictureDto requestDto);

    public PictureDto getPictureById(Long id);
}
