package com.walking.lesson67_locks.task3;

import java.util.concurrent.locks.ReentrantLock;

import com.walking.lesson67_locks.task3.model.Counter;

/**
 * Реализуйте программу, увеличивающую значение счетчика на 1
 * несколькими параллельными потоками одновременно вплоть до числа, указанного пользователем.
 * Каждый раз, когда число превышает значение, кратное 100,
 * одним из потоков в консоль должно выводиться соответствующее сообщение.
 * <p>
 * Использование атомик-типов недопустимо.
 */
public class Main {
    public static void main(String[] args) {
        final int threads=5;
        final int border=2002;
        Counter counter=new Counter(border);
        fillCounter(counter, threads);

    }

    static void fillCounter(Counter counter, int threads){
        ReentrantLock locker=new ReentrantLock();
        for (int i = 0; i < threads; i++) {
            Thread t=new Thread(()->{
                int value=0;
                while (true) {
                    try{
                        locker.lock();
                        value=counter.increase();
                        if (value==counter.getBorder()) {
                            break;
                        }
                        if ((value-1)%100==0) {
                            System.out.println(value);
                        }
                    } finally{
                        locker.unlock();
                    }
                    
                }
            });
            t.start();
        }
    }
}