package com.walking.lesson60_thread.task4;

import com.walking.lesson60_thread.task4.service.ResultFromOtherThreadService;

import java.util.Random;

/**
 * Решите Задачу 3, не используя Thread.join().
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ResultFromOtherThreadService<String> resultFromOtherThread = new ResultFromOtherThreadService<>(Main::someMethod);
        System.out.println("Main thread");
        System.out.println(resultFromOtherThread.getOperationResult(Thread.currentThread()));
        System.out.println("Main thread");

        ResultFromOtherThreadService<int[][]> resultFromOtherThread2 = new ResultFromOtherThreadService<>(Main::someMethod2);
        System.out.println("Main thread");
        System.out.println(resultFromOtherThread2.getOperationResult(Thread.currentThread()));
        System.out.println("Main thread");
    }
    private static String someMethod(){
        return "Hello world";
    }
    private static int[][] someMethod2(){
        int[][] resultArray = new int[1000][1000];
        Random random = new Random();

        for (int i=0;i<resultArray.length;i++){
            for (int j=0;j<resultArray[i].length;j++){
                resultArray[i][j]= random.nextInt(10);
            }
        }
        return resultArray;
    }
}