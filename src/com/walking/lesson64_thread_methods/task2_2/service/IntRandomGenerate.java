package com.walking.lesson64_thread_methods.task2_2.service;

import java.util.Random;

public class IntRandomGenerate {
    private final int minValue;
    private final int maxValue;

    Random random;

    public IntRandomGenerate(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;

        random = new Random();
    }

    public int generate() {
        return random.nextInt(minValue, maxValue);
    }
}
