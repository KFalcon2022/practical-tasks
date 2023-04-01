package com.walking.lesson60.task2.interfaces;

import java.util.Random;

public class FirstArrayService implements ArrayService {
    @Override
    public int[][] fillTwoDArray(int n, int m) {
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = ArrayService.getRandomNumber(MIN, MAX);
            }
        }

        return result;
    }


}
