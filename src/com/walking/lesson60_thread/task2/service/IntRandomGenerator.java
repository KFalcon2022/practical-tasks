package com.walking.lesson60_thread.task2.service;

import java.util.Random;

public class IntRandomGenerator {
    private int minValue;
    private int maxValue;
    private Random random;

    public IntRandomGenerator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;

        this.random=new Random();
    }
    public int generate(){
        return random.nextInt(minValue,maxValue);
    }
}
