package com.example.learn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tag")
@Data

public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //    @ManyToMany(mappedBy = "uid")
    private List<Long> followers;
    private List<Long> posts;
    @Column(columnDefinition = "FFF")
    private String hashTagColor;

}
