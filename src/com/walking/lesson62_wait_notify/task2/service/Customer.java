package com.walking.lesson62_wait_notify.task2.service;

import com.walking.lesson62_wait_notify.task2.util.Randomizer;

public class Customer extends Thread {
    private int maxDemand;
    private Storage storage;

    public Customer(int maxDemand, Storage storage){
        this.maxDemand=maxDemand;
        this.storage=storage;
    }

    public void run(){
        String s;
        int demand;
        boolean success;
        while (!Thread.interrupted()) {
            s="";
            demand=Randomizer.getNumber(maxDemand);
            success=false;
            while (!success) {
                try {
                    s=Thread.currentThread().getName()+
                    " try to get:"+demand+" from storage";
                    success=storage.get(demand);
                    if (success){
                        s=s+", success.";
                    } else{
                        s=s+", fail.";
                        demand--;
                    }
                    System.out.println(s);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
