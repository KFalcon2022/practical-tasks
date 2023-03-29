package com.walking.lesson60_thread.Task1;

import java.time.LocalDateTime;

public class Main {
    public static void main (String[] args) {
        Thread timer = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(LocalDateTime.now());
                    Thread.sleep(2000);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }, "Sub");
        timer.start();
        try {
            timer.join();
        }
        catch (InterruptedException e){
            System.out.println("Thread error");
        }
    }
}
