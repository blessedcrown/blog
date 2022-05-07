package com.example.blog.domain.picture.service;

import com.example.blog.domain.picture.dto.PictureDto;
import com.example.blog.domain.picture.entity.Picture;
import com.example.blog.domain.picture.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//https://kyuhyuk.kr/article/spring-boot/2020/07/22/Spring-Boot-JPA-MySQL-Board-Post-File-Upload-Download
@RequiredArgsConstructor
@Service
public class PictureServiceImpl implements PictureService{

    private final PictureRepository pictureRepository;

    @Override
    public Long saveFile(PictureDto requestDto) {
        return pictureRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public PictureDto getPictureById(Long id) {
        Picture pic = pictureRepository.findById(id).get();

        PictureDto found = PictureDto.builder()
                .id(id)
                .originalFileName(pic.getOriginalFileName())
                .fileName(pic.getFileName())
                .filePath(pic.getFilePath())
                .build();
        return found;
    }
}
