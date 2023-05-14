package com.walking.lesson72_blocking_non_blocking_queue.task3.model;

public class Task implements Runnable {
    private final Integer number;

    public Task(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number);

        try {
            Thread.sleep(number * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getNumber() {
        return number;
    }
}
