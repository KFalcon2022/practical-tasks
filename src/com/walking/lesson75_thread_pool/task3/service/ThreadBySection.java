package com.walking.lesson75_thread_pool.task3.service;

import java.util.concurrent.Executors;

import com.walking.lesson75_thread_pool.task3.util.Fillable;
import com.walking.lesson75_thread_pool.task3.util.Randomizer;

public class ThreadBySection implements Fillable {
    int sectionLength;

    public ThreadBySection(int sectionLength){
        this.sectionLength=sectionLength;
    }

    @Override
    public int[][] fillArray(int width, int length) {
        if (length<sectionLength)
            throw new RuntimeException("Длина не может быть меньше секции!");
        var tPool=Executors.newFixedThreadPool(8);
        int[][] result=new int[width][length];
        int countSection=(int)Math.ceil(length/sectionLength);
        for (int j = 0; j < width; j++) {
            for (int i = 1; i <= countSection; i++) {
                tPool.execute(new FillOneSection(result, j, sectionLength, i));
            }
        }
        tPool.close();
        while (!tPool.isTerminated()) {
            
        }
        return result;
    }
}
class FillOneSection implements Runnable{
    int[][] array;
    int row;
    int sectionLength;
    int sectionNumber;

    public FillOneSection(int[][] array, int row, int sectionLength, int sectionNumber){
        this.array=array;
        this.row=row;
        this.sectionLength=sectionLength;
        this.sectionNumber=sectionNumber;
    }

    public void run(){
        int start=sectionLength*(sectionNumber-1);
        int end=(sectionNumber==(int)Math.ceil(array[0].length/sectionLength))
        ?array[0].length
        :sectionLength*sectionNumber;
        for (int i = start; i < end; i++) {
            array[row][i]=Randomizer.getNumber();
        }
    }
}
