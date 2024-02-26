package com.walking.lesson64_thread_methods.service;

import java.util.Random;

public class IntRandomGenerator {
    private final int startIndex;
    private final int endIndex;
    private final Random random;

    public IntRandomGenerator(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        random = new Random();
    }

    public int getNumber() {
        return random.nextInt(startIndex, endIndex);
    }
}
