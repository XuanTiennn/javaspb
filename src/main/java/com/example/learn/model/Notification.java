package com.example.learn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "notification")
@Data

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
//    @Column(columnDefinition = "false")
    private Boolean read;
    private Long sender;
    private Long receiver;
    private Long post;
    private Long comment;
}
