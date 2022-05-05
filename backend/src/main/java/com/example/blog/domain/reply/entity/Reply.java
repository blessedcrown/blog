package com.example.blog.domain.reply.entity;

import com.example.blog.domain.BaseEntity;

import javax.persistence.*;

@Entity
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String reply;

}
