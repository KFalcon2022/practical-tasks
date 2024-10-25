package com.walking.lesson60_thread.task4;

import java.util.concurrent.Callable;

public class AnotherThreadResult<T> {
    public T getResult(Callable<T> request){
        CallableThread<T> ct=new CallableThread<>(request);
        ct.start();
        while (ct.isAlive()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ct.getResult();
    }
}

class CallableThread<T> extends Thread{
    private Callable<T> request;
    private T result;
    public CallableThread(Callable<T> request){
        this.request=request;
    }

    public void run(){
        try {
            result=request.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T getResult(){
        return result;
    }
}
