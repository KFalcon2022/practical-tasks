package com.walking.lesson62_wait_notify.task2.service;

public class Storage {
    private int maxCount;
    private int count=0;

    public Storage(int maxCount){
        this.maxCount=maxCount;
    }

    public int getCount(){
        return count;
    }

    public synchronized int put(int supply) throws InterruptedException{
        while (count>=Math.round(maxCount/4)) {
            wait();
        }
        if (supply+count>maxCount){
            int remainder=supply+count-maxCount;
            count=maxCount;
            notifyAll();
            return remainder;
        } else{
            count+=supply;
            notifyAll();
            return 0;
        }
    }

    public synchronized boolean get(int demand) throws InterruptedException{
        while (count==0) {
            wait();
        }
        if (count<demand){
            notifyAll();
            return false;
        } else{
            count-=demand;
            notifyAll();
            return true;
        }
    }
}
