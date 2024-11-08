package com.walking.lesson68_semaphore.task1.model;

public class Philosopher extends Thread {
    private String name;
    private Fork left;
    private Fork right;
    private Broker broker;

    public Philosopher(String name, Fork left, Fork right, Broker broker){
        this.name=name;
        this.broker=broker;
        this.left=left;
        this.right=right;
        this.setName(name);

    }

    public void run(){
        int ate=0;
        while (ate<3) {
            meditate();
            try {
                broker.getSemaphore().acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (broker.isAvailable(this)) {
                if (right.getLocker().tryLock()) {
                    System.out.println(name+" взял правую вилку:"+right.getNumber());
                    if (left.getLocker().tryLock()) {
                        System.out.println(name+" взял левую вилку:"+left.getNumber());
                        ate=eat(ate);
                        System.out.println(name+" положил левую вилку:"+left.getNumber());
                        left.getLocker().unlock();
                    }
                    System.out.println(name+" положил правую вилку:"+right.getNumber());
                    right.getLocker().unlock();
                }
            }
            broker.getSemaphore().release(1);
        }
    }

    public Fork getRight(){
        return right;
    }

    public Fork getLeft(){
        return left;
    }

    private int eat(int ate){
        System.out.println(name+" ест "+(ate+1)+" раз");
        return ate+1;
    }

    private void meditate(){
        System.out.println(name+" размышляет");
    }
}
