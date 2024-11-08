package com.walking.lesson68_semaphore.task1.model;

import java.util.concurrent.Semaphore;

public class Broker {
    private Semaphore sem;

    public Broker(){
        this.sem=new Semaphore(2);
    }
    
    public Semaphore getSemaphore(){
        return sem;
    }

    public boolean isAvailable(Philosopher philosopher){
        if (!philosopher.getRight().getLocker().isLocked()
        ||philosopher.getLeft().getLocker().isLocked()) {
            return true;
        }
        return false;
    }
}
