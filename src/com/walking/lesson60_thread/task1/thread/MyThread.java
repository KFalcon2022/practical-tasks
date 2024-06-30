package com.walking.lesson60_thread.task1.thread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH ч. mm мин. ss сек.")));
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
