package com.walking.lesson60.task2.interfaces;

import com.walking.lesson60.task2.thread.FillOneDArrayThread;

public class SecondArrayService implements ArrayService {
    @Override
    public int[][] fillTwoDArray(int n, int m) {
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            new FillOneDArrayThread(i, m, result).start();
        }

        return result;
    }
}
