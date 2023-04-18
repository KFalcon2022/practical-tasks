package com.walking.lesson65.Task1;

public class Main {
    public static void main(String[] args){
        CounterService cs = new CounterService(10);

        Counter c1 = new Counter(500);

        cs.attach(1, c1);
        cs.attach(8, new Counter(1000));
        cs.attach(0, new Counter(0));
        cs.detach(0);
        cs.attach(5, c1);
        cs.detach(9);

        // Буду увеличивать один счетчик с 2 потоков
        Thread t1 = new Thread(new CounterProcess(c1));
        Thread t2 = new Thread(new CounterProcess(c1));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
        }
    }
}

class CounterProcess implements Runnable {
    Counter counter;
    public CounterProcess(Counter c){
        this.counter = c;
    }

    public void run(){
        int iterations = 30;
        while (iterations-- > 0) {
            this.counter.add(5);
            Thread.currentThread().yield();
        }
    }
}