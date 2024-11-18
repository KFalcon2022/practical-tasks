package com.walking.lesson75_thread_pool.task3.util;

import java.util.concurrent.Callable;

public class AnotherThreadResult<T> {
    public T getResult(Callable<T> request){
        CallableThread<T> ct=new CallableThread<>(request);
        ct.start();
        try {
            ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
