package com.example.blog.domain.picture.service;

import com.example.blog.domain.picture.entity.Picture;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PictureHandler {

    public List<Picture> parsePictureInfo(List<MultipartFile> multipartFiles) throws Exception {
        List<Picture> picList = new ArrayList<>();

        if(multipartFiles.isEmpty()) {
            return picList;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = simpleDateFormat.format(new Date());

        String absolutePath = new File("").getAbsolutePath() + "\\";
        String path = "images/" + currentDate;
        File file = new File(path);

        if(!file.exists()) {
            file.mkdirs();
        }

        for(MultipartFile multipartFile : multipartFiles) {
            if(!multipartFile.isEmpty()) {
                String contentType = multipartFile.getContentType();
                String originalFileExtension;
                if(ObjectUtils.isEmpty(contentType)) break;
                else {
                    if(contentType.contains("image/jpeg")) originalFileExtension = ".jpg";
                    else if(contentType.contains("image/png")) originalFileExtension = ".png";
                    else if(contentType.contains("image/gif")) originalFileExtension = ".gif";
                    else break;
                }
                String newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                Picture pic = Picture.builder()
                        .originalFileName(multipartFile.getOriginalFilename())
                        .fileName(newFileName)
                        .filePath(path + "/" + newFileName)
                        .build();
                picList.add(pic);

                file = new File(absolutePath + path + "/" + newFileName);
                multipartFile.transferTo(file);
            }
        }
        return picList;
    }
}
