package com.walking.lesson75_thread_pool.task4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


/**
 * Реализуйте программу, которая выводит числа от 0 до 100 в консоль.
 * Выведения каждого десятка должно быть вынесено в отдельный поток,
 * в котором будут запущены потоки на выведение каждого конкретного числа.
 * <p>
 * Каждый конечный поток обязан спать в течении 500мс после того,
 * как выведет число в консоль.
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool fjp=new ForkJoinPool();

        for (int i = 0; i < 10; i++) {
            fjp.invoke(new printerCaller(i, fjp));
        }
    }
}
class printer extends RecursiveAction {
    int number;

    public printer(int number){
        this.number=number;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName() + ": " + number);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
}
class printerCaller extends RecursiveAction {
    int decade;

    public printerCaller(int decade, ForkJoinPool fjp){
        this.decade=decade;
    }

    @Override
    protected void compute() {
        for (int i = decade*10+1; i < (decade+1)*10+1; i++) {
            new printer(i).fork();
        }
    }

    
}