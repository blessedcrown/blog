package com.example.blog.domain.post.entity;

import com.example.blog.domain.BaseEntity;
import com.example.blog.domain.like.entity.Likes;
import com.example.blog.domain.reply.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private Long pictureId;

    @OneToMany
    @JoinColumn(name = "reply_id")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "like_id")
    private List<Likes> likes =  new ArrayList<>();

    public void updateTitle(String title) { this.title = title; }
    public void updateContent(String content) {
        this.content = content;
    }
}
