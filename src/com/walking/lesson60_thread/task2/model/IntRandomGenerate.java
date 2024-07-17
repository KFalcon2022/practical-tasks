package com.walking.lesson60_thread.task2.model;

import java.util.Random;

public class IntRandomGenerate {
    private final int minValue;
    private final int maxValue;

    private final Random random;

    public IntRandomGenerate(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;

        random = new Random();
    }

    public int generate() {
        return random.nextInt(minValue, maxValue);
    }
}
