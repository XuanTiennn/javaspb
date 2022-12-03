package com.example.learn.dto;

public class ProductDTO {
    public String getName() {
        return name;
    }

    public ProductDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String name;
    public Long id;
}
