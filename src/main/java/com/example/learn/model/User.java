package com.example.learn.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
@Entity
@Table(name = "user")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String address;
    private String passWord;
    private String email;
    private String image;
    private String bio;
    private String skills;
    private String education;
    private String work;
    private List<Long> posts;
    private List<Long> comments;
    private List<Long> followTags;
    private List<Long> followers;
    private List<Long> followings;
    private List<Long> bookmarks;
    private String refreshToken;

}
