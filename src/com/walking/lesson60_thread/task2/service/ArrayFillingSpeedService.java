package com.walking.lesson60_thread.task2.service;

public class ArrayFillingSpeedService {
    private static long startTime;
    private static long endTime;

    public static <T extends ArrayFillingService> void checkSpeed(T fillingClass, int[][] arraySize){
        startTime=System.currentTimeMillis();
        fillingClass.fill(arraySize);
        endTime=System.currentTimeMillis();

        System.out.printf("Speed of %s: %d ms%n",fillingClass,endTime-startTime);
    }

}
