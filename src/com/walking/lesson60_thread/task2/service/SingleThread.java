package com.walking.lesson60_thread.task2.service;

import com.walking.lesson60_thread.task2.util.Fillable;
import com.walking.lesson60_thread.task2.util.Randomizer;

public class SingleThread implements Fillable  {

    @Override
    public int[][] fillArray(int width, int length) {
        int[][] result=new int[width][length];
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < length; i++) {
                result[j][i]=Randomizer.getNumber();
            }
        }
        return result;
    }
    
}
