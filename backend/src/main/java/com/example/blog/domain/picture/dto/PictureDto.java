package com.example.blog.domain.picture.dto;

import com.example.blog.domain.picture.entity.Picture;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class PictureDto {
    private Long id;
    private String originalFileName;
    private String fileName;
    private String filePath;

    public Picture toEntity() {
        Picture pic = Picture.builder()
                .id(id)
                .originalFileName(originalFileName)
                .fileName(fileName)
                .filePath(filePath)
                .build();
        return pic;
    }
}
