package com.example.learn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TagDTO {
    private Long id;
    private String name;
    private List<Long> followers;
    private List<Long> posts;
    private String hashTagColor;
}
