package com.walking.lesson64_thread_methods.model;

import java.util.Random;

public class RandomGenerator {
    private final Random random;

    private final int minValue;
    private final int maxValue;

    public RandomGenerator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;

        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(minValue, maxValue);
    }
}
