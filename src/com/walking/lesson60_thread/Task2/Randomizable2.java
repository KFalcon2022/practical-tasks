package com.walking.lesson60_thread.Task2;

import java.util.Random;

public interface Randomizable2 {
    public default long[][] randomize(int m, int n){
        long[][] data = new long[m][n];

        class SubThread extends Thread{
            int rowNum;
            public SubThread(String name, int rowNum){
                super(name);
                this.rowNum = rowNum;
            }

            public void run(){
                for (int j = 0; j < n; j++)
                    data[rowNum][j] = new Random().nextLong(Long.MAX_VALUE);
            }
        }

        for (int i = 0; i < m; i++) {
            Thread rowThread = new SubThread("Sub", i);
            rowThread.start();
            try {
                rowThread.join();
            }
            catch (InterruptedException e) {
                System.out.println("SubThread interrupted");
            }
        }
        return data;
    }
}
