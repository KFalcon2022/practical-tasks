package com.walking.lesson60_thread.task4;

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

        return getResult();
    }

    public R getResult() throws InterruptedException {
        while (thread.isAlive()) {
            //Ничего не делаем. Можно вставить сюда sout, чтобы было нагляднее
        }

        return result;
    }

    public void start() {
        thread.start();
    }
}
