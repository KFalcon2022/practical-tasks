package com.walking.lesson60_thread.task1;

import java.time.LocalTime;

/**
 * Напишите программу, которая пишет в консоль текущее время каждый две секунды,
 * пока программа запущена.
 */
public class Main {
    public static void main(String[] args) {
        Runnable watch=()->{
            while (true){
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        Thread subTread=new Thread(watch);
        subTread.start();
    }
}