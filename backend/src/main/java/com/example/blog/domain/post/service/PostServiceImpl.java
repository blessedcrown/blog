package com.example.blog.domain.post.service;

import com.example.blog.domain.picture.entity.Picture;
import com.example.blog.domain.picture.repository.PictureRepository;
import com.example.blog.domain.picture.service.PictureHandler;
import com.example.blog.domain.post.dto.PostDto;
import com.example.blog.domain.post.dto.PostMapper;
import com.example.blog.domain.post.entity.Post;
import com.example.blog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final PictureHandler pictureHandler;
    private final PictureRepository pictureRepository;
    @Override
    public PostDto.CreateResponse create(PostDto.CreateRequest request) throws Exception {
        Post saved = postRepository.save(postMapper.toEntity(request));

        List<Picture> picList = pictureHandler.parsePictureInfo(request.getMultipartFiles());
        savePicture(picList, saved);
        return postMapper.toCreateResponse(saved);
    }

    @Override
    public PostDto.DetailResponse findById(Long id) {
        Post found = postRepository.findById(id).get();
        return postMapper.toDetailResponse(found);
    }

    @Override
    public Page<PostDto.DetailResponse> findAll(Pageable pageable) {
        return postRepository.findAllByOrderByIdDesc(pageable).map(PostMapper::toDetailResponse);
    }

    @Override
    public PostDto.UpdateResponse update(PostDto.UpdateRequest request, Long id) {
        Post found = postRepository.findById(id).get();
        List<Picture> preexistingPicList = found.getPictures();
        //사진 수정 참고 자료
        //https://moonsbeen.tistory.com/300

        //파일을 첨부하였는지 체크
        if (request.getMultipartFiles().size() != 0){
            try {
                //전에 업로드된 파일이 있었으면 삭제해야한다
                if (preexistingPicList != null) {
                    for (Picture pic : preexistingPicList) {
                        File file = new File(pic.getFilePath());
                        file.delete();
                    }
                }
                List<Picture> newPicList = pictureHandler.parsePictureInfo(request.getMultipartFiles());
                savePicture(newPicList, found);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        found.updateTitle(request.getTitle());
        found.updateContent(request.getContent());

        return postMapper.toUpdateResponse(found);
    }

    @Override
    public void delete(Long id) {
        Post toDelete = postRepository.findById(id).get();
        postRepository.delete(toDelete);
    }

    public void savePicture(List<Picture> picList, Post post) {
        if(picList.isEmpty()) {

        }
        else {
            //List<Picture> pictureBeans = new ArrayList<>();
            for(Picture pic : picList) {
                post.getPictures().add(pictureRepository.save(pic));
            }
            //saved.setPictures(pictureBeans);
        }
    }
}
