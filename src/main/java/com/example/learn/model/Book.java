package com.example.learn.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = true)
    private String category;

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = true)
    private int pageCount;

    @Column(nullable = true)
    private int soldCount;

    @Column(nullable = true)
    private String imageUrl;

    @Column(nullable = true)
    private String publicId;
    @Column(nullable = true)
    private String description;
}
