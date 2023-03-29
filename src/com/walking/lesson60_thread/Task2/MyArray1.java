package com.walking.lesson60_thread.Task2;

public class MyArray1 implements Randomizable1{
    long[][] data;

    public MyArray1(int m, int n){
        this.data = randomize(m, n);
    }
}
