package com.walking.lesson60_thread.task3;

import java.util.Objects;
import java.util.concurrent.Callable;

public class CallableThread<R> {
    private final Thread thread;
    private R result;

    public CallableThread(Callable<R> callable) {
        Objects.requireNonNull(callable);

        this.thread = new Thread(() -> {
            try {
                this.result = callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public R startAndGet() throws InterruptedException {
        thread.start();
        thread.join();

        return result;
    }

    public R getResult() throws InterruptedException {
        if (thread.isAlive()) {
            thread.join();
        }

        return result;
    }

    public void start() {
        thread.start();
    }
}
