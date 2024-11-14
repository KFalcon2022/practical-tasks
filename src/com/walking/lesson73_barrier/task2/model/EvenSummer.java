package com.walking.lesson73_barrier.task2.model;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.LongAdder;

public class EvenSummer implements Runnable {
    private int[][] array;
    private LongAdder externalCounter;
    private LongAdder internalCounter;
    private CyclicBarrier internalBarrier;
    private CyclicBarrier externalBarrier;

    public EvenSummer(int[][] array, LongAdder counter, CyclicBarrier barrier){
        this.array=array;
        this.externalCounter=counter;
        this.internalCounter=new LongAdder();
        this.externalBarrier=barrier;
        this.internalBarrier=new CyclicBarrier(array.length
        , ()->{
            externalCounter.add(internalCounter.sum());
            try {
                externalBarrier.await();
            } catch (InterruptedException e) {
                System.out.println(4);
            } catch (BrokenBarrierException e) {
                System.out.println(1);
            }
        });
    }
    
    public void run(){
        for (int[] singleArray : array) {
            Thread t=new Thread(()->{
                for (int i : singleArray) {
                    if (i%2==0)
                        internalCounter.increment();
                }
                try {
                    internalBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println(2);
                }
            });
            t.start();
        }
    }
}
