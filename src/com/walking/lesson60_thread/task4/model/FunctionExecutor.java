package com.walking.lesson60_thread.task4.model;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class FunctionExecutor<T, R> implements Callable<R> {
    T value;
    Function<T, R> function;
    R result;

    public FunctionExecutor(T value, Function<T, R> function) {
        this.value = value;
        this.function = function;
    }

    @Override
    public R call() throws InterruptedException {
        Thread thread = new Thread(() -> result = function.apply(value), "thread");

        thread.start();

        while (true) {
            if (!thread.isAlive()) {
                break;
            }
        }

        return result;
    }
}
