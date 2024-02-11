package com.walking.lesson60_thread.task3.service;

import java.util.concurrent.Callable;

public class ResultFromOtherThreadService<T> {
    private T resultValue;
    private Thread thread;
    private Callable<T> operation;
    private final Runnable RUNNABLE_INTERFACE = ()->{
        try {
            resultValue=operate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
    public ResultFromOtherThreadService(Callable<T> operation){
        this.operation=operation;
        thread = new Thread(RUNNABLE_INTERFACE);
    }
    public T getOperationResult () throws InterruptedException{
        thread.start();
        thread.join();
        return resultValue;
    }
    private T operate () throws Exception {
        return operation.call();
    }

}
