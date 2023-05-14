package com.walking.lesson72_blocking_non_blocking_queue.task3.service;

import java.util.Random;

public class IntRandomGenerator {
    private final int minValue;
    private final int maxValue;

    private final Random random;

    public IntRandomGenerator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;

        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(minValue, maxValue);
    }
}
