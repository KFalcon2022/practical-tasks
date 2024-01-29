package com.walking.lesson60_thread.task1;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * Напишите программу, которая пишет в консоль текущее время каждый две секунды,
 * пока программа запущена.
 */
public class Main {
    private static final Runnable SHOW_TIME_RUN_INTERFACE = ()->{
        while (true){
            System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
            try{
                //Thread.sleep(2000);
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
    };
    public static void main(String[] args) throws InterruptedException {
        new Thread(SHOW_TIME_RUN_INTERFACE).start();
    }
}