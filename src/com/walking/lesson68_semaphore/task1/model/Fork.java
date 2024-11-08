package com.walking.lesson68_semaphore.task1.model;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private ReentrantLock locker;
    private int number;

    
    public Fork(int number){
        this.locker=new ReentrantLock();
        this.number=number;
    }

    public int getNumber(){
        return number;
    }

    public ReentrantLock getLocker(){
        return locker;
    }
}
