package com.walking.lesson60_thread.task4.service;



import java.util.concurrent.Callable;

// Без join()
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
    public T getOperationResult (Thread mainThread) throws InterruptedException{
//        mainThread.setPriority(1);
        thread.start();
        thread.run();
//        thread.setPriority(10);
        return resultValue;
    }
    private T operate () throws Exception {
        return operation.call();
    }

}

