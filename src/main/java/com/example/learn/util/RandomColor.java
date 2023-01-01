package com.example.learn.util;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Random;
@Data
@RequiredArgsConstructor
public class RandomColor {
    public static String Random() {
        Random numGen = new Random();
        return new String(numGen.nextInt(256) + ", " + numGen.nextInt(256) + ", " + numGen.nextInt(256));
    }
}
