package com.walking.lesson29.Task2;

import com.walking.lesson28.Task1.Test;

public class Main {
    public static void main(String[] args) {
        Test<?> testLong = makeGeneric(Long.valueOf(400));
        // output
        System.out.println(testLong.getDegree(4));
    }

    public static Test<? extends Number> makeGeneric(Number obj){
        return new Test<>(obj);
    }
}
