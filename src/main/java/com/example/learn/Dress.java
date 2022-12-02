package com.example.learn;

import org.springframework.stereotype.Component;

@Component
public class Dress implements DressDTO {
    @Override
    public  void wear(){
        System.out.println("abc");
    }
}
