package com.walking.lesson60_thread.Task2;

import java.util.Random;

public interface Randomizable1 {
    public default long[][] randomize(int m, int n){
        long[][] data = new long[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                data[i][j] = new Random().nextLong(Long.MAX_VALUE);
        return data;
    }
}
