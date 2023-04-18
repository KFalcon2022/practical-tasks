package com.walking.lesson64.Task2;

import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Thread timerThread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(LocalDateTime.now());
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        timerThread.start();

        Thread arrayThread = new Thread(new ArrayFiller(10050, 10500));
        arrayThread.start();

        try{
            arrayThread.join();
        }
        catch (InterruptedException e) {}
    }
}

class ArrayFiller implements Runnable {
    private long[][] array;
    private int rows;
    private int cols;

    public ArrayFiller(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.array = new long[rows][cols];
    }

    public void run() {
        for (int i=0; i<rows; i++) {
            //System.out.println("Row %d".formatted(i));
            for (int j = 0; j < cols; j++) {
                array[i][j] = new Random().nextLong(Long.MAX_VALUE);
                //Thread.currentThread().yield();
            }
            Thread.currentThread().yield();
        }
    }
}