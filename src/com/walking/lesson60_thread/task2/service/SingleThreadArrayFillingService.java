package com.walking.lesson60_thread.task2.service;

public class SingleThreadArrayFillingService implements ArrayFillingService {
    private final IntRandomGenerator randomGenerator;

    public SingleThreadArrayFillingService(IntRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public int[][] fill(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j ++) {
                array[i][j] = randomGenerator.generate();
            }
        }

        return array;
    }
}
