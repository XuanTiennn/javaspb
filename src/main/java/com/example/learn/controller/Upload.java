package com.example.learn.controller;

import com.example.learn.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class Upload {
    private final CloudinaryService cloudinaryService;
    @Autowired
    public Upload(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return cloudinaryService.uploadImage(file);
    }

}
