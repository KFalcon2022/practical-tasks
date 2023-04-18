package com.walking.lesson65.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger number;
    public Counter(int value){
        this.number = new AtomicInteger(value);
    }

    public int get(){
        return this.number.get();
    }

    public synchronized void add(int value){
        int curValue = this.number.addAndGet(value);
        System.out.println("Current value = %d".formatted(curValue));
    }

    public synchronized void sub(int value){
        int curValue = this.number.addAndGet(-value);
        System.out.println("Current value = %d".formatted(curValue));
    }

    public synchronized void reset(){
        this.number.set(0);
        System.out.println("Current value = 0");
    }

}
