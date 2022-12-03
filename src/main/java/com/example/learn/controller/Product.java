package com.example.learn.controller;

import com.example.learn.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Product {
    @RequestMapping("/")
    @GetMapping
    public ResponseEntity<ProductDTO> GetAll(){
        ProductDTO productDTO=new ProductDTO("Iphone",1342325623L);
        List<ProductDTO> productDTOS = null;
        productDTOS.add(0,productDTO);
        return (ResponseEntity<ProductDTO>) productDTOS;
    }
}
