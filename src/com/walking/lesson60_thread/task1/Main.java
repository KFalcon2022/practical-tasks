package com.walking.lesson60_thread.task1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Напишите программу, которая пишет в консоль текущее время каждый две секунды,
 * пока программа запущена.
 */
public class Main {
    public static void main(String[] args) {
        getTimeEvery2Seconds();
    }

    private static void getTimeEvery2Seconds() {
        while (true) {
            var t = new Thread(() ->
                    System.out.println(LocalTime.now()
                            .format(DateTimeFormatter.
                                    ofPattern("hh.mm.ss"))));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            t.start();
        }
    }
}
