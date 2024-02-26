package com.walking.lesson64_thread_methods.daemon;

import java.time.LocalTime;

public class CurrentTimeService extends Thread {
    public CurrentTimeService(boolean isDaemon) {
        this.setDaemon(isDaemon);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println(LocalTime.now());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
