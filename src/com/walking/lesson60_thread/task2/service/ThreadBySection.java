package com.walking.lesson60_thread.task2.service;

import com.walking.lesson60_thread.task2.util.Fillable;
import com.walking.lesson60_thread.task2.util.Randomizer;

public class ThreadBySection implements Fillable {
    int sectionLength;

    public ThreadBySection(int sectionLength){
        this.sectionLength=sectionLength;
    }

    @Override
    public int[][] fillArray(int width, int length) {
        if (length<sectionLength)
            throw new RuntimeException("Длина не может быть меньше секции!");
        int[][] result=new int[width][length];
        int countSection=(int)Math.ceil(length/sectionLength);
        for (int j = 0; j < width; j++) {
            for (int i = 1; i <= countSection; i++) {
                FillOneSection t=new FillOneSection(result, j, sectionLength, i);
                t.start();
            }
        }
        return result;
    }
}
class FillOneSection extends Thread{
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
