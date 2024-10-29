package com.walking.lesson62_wait_notify.task2.service;

import com.walking.lesson62_wait_notify.task2.util.Randomizer;

public class Supplier extends Thread {
    private int maxSupply;
    private Storage storage;

    public Supplier(int maxSupply, Storage storage){
        this.maxSupply=maxSupply;
        this.storage=storage;
    }

    public void run(){
        try {
        String s;
        int supply;
        boolean success;
        while (!Thread.interrupted()) {
            s="";
            supply=Randomizer.getNumber(maxSupply);
            success=false;
            while (!success) {
                
                    s=Thread.currentThread().getName()+
                    " put:"+supply+" in storage";
                    supply=storage.put(supply);
                    s=s+", remainder:"+supply;
                    System.out.println(s);
                    if (supply==0) {
                        success=true;
                    }
                    Thread.sleep(5000);

            }
        }
    } catch (InterruptedException e) {
        return;
    }
    }
}
