package com.example.learn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String image;
    private Long author;
    private String slug;
    private List<Long> tags;
    private String content;
    private List<Long> likes;
    private List<Long> bookmarks;


}
