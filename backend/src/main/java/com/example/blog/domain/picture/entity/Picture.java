package com.example.blog.domain.picture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Picture {
    /*
    * 업로드된 실제 파일명, 서버에 저장된 파일명, 파일이 서버에 저장된 위치만을 DB에 기록한다
    * 실제 파일은 서버에 저정한다
    * https://velog.io/@pyo-sh/Spring-Boot-%ED%8C%8C%EC%9D%BC%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%97%85%EB%A1%9C%EB%93%9C-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;
}
