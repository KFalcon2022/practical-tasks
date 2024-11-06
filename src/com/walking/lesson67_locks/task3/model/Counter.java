package com.walking.lesson67_locks.task3.model;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter;
    private int border;
    //private ReentrantLock locker;

    public Counter(int boarder){
        this.counter=0;
        this.border=boarder;
        //this.locker=new ReentrantLock();
    }

    public int increase(){
        // try{
        //     locker.lock();
            return (counter==border)?counter:++counter;
        // } finally{
        //     locker.unlock();
        // }
    }

    public int getBorder(){
        return border;
    }
}
