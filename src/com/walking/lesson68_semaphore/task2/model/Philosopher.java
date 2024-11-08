package com.walking.lesson68_semaphore.task2.model;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private String name;
    private Semaphore leftPhilosopher;
    private Semaphore rightPhilosopher;
    private Semaphore semaphore;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork){
        this.name=name;
        this.setName(name);
        this.rightFork=rightFork;
        this.leftFork=leftFork;
        this.semaphore=new Semaphore(2);

    }

    public void setRightPhilosopher(Semaphore right){
        this.rightPhilosopher=right;
    }

    public void setLeftPhilosopher(Semaphore left){
        this.leftPhilosopher=left;
    }

    public Semaphore getSemaphore(){
        return semaphore;
    }

    public void run(){
        int ate=0;
        while (ate<3) {
            if (semaphore.tryAcquire(2)) {           
                if (rightPhilosopher.tryAcquire(1)) {
                    System.out.println(name+" взял правую вилку:"+rightFork.getNumber());
                    if (leftPhilosopher.tryAcquire(1)) {
                        System.out.println(name+" взял левую вилку:"+leftFork.getNumber());
                        ate=eat(ate);
                        System.out.println(name+" положил правую вилку:"+rightFork.getNumber());
                        rightPhilosopher.release(1);
                        System.out.println(name+" положил левую вилку:"+leftFork.getNumber());
                        leftPhilosopher.release(1);
                        semaphore.release(2);
                        continue;
                    } else{
                        System.out.println(name+" положил правую вилку:"+rightFork.getNumber());
                        rightPhilosopher.release(1);
                    }
                }
                semaphore.release(2);
                meditate();
            } else {
                meditate();
            }
        }
    }

    private int eat(int ate){
        System.out.println(name+" ест "+(ate+1)+" раз");
        return ate+1;
    }

    private void meditate(){
        System.out.println(name+" размышляет");
    }
}
