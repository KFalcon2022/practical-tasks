package com.walking.lesson62_wait_notify.task2.service;

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
