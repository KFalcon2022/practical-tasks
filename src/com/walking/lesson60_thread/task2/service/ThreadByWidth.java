package com.walking.lesson60_thread.task2.service;

import com.walking.lesson60_thread.task2.util.Fillable;
import com.walking.lesson60_thread.task2.util.Randomizer;

public class ThreadByWidth implements Fillable {

    @Override
    public int[][] fillArray(int width, int length) {
        int[][] result=new int[width][length];
        for (int j = 0; j < width; j++) {
            FillOneRow t=new FillOneRow(String.valueOf(j), result, j);
            t.start();
        }
        return result;
    }
    
}

class FillOneRow extends Thread{
    int[][] array;
    int row;
    FillOneRow(String name, int[][] array, int row){
        super(name);
        this.array=array;
        this.row=row;
    }

    public void run(){
        for (int i = 0; i < array[0].length; i++) {
            array[row][i]=Randomizer.getNumber();
        }
    }
}
