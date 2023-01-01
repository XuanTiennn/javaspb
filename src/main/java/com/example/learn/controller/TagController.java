package com.example.learn.controller;

import com.example.learn.dto.TagDTO;
import com.example.learn.model.Tag;
import com.example.learn.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService service;

    @GetMapping
    public List<Tag> getList() {
        return service.getList();
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag request) {
        return service.createTag(request);
    }

    @GetMapping("/{id}")
    public Optional<Tag> getItem(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Tag updateItem(@PathVariable Long id, @RequestBody TagDTO request) {
        return service.updateTag(id, request);
    }

}
