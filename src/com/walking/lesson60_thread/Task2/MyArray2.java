package com.walking.lesson60_thread.Task2;

public class MyArray2 implements Randomizable2{
    long[][] data;

    public MyArray2(int m, int n){
        this.data = randomize(m, n);
    }
}
