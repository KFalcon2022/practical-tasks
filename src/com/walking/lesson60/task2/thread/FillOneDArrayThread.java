package com.walking.lesson60.task2.thread;

import static com.walking.lesson60.task2.interfaces.ArrayService.*;

public class FillOneDArrayThread extends Thread {
    private final int i;
    private final int m;
    private final int[][] result;

    public FillOneDArrayThread(int i, int m, int[][] result) {
        this.i = i;
        this.m = m;
        this.result = result;
    }

    @Override
    public void run() {
        for (int j = 0; j < m; j++) {
            result[i][j] = getRandomNumber(MIN, MAX);
        }
    }
}
