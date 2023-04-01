package com.walking.lesson60.task2.interfaces;

import java.util.Random;

public interface ArrayService {
    int MIN = 1;
    int MAX = 10;
    int [][] fillTwoDArray(int n, int m);

    static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max + 1)
                .findFirst()
                .getAsInt();
    }
}
