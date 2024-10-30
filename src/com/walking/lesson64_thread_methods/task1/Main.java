package com.walking.lesson64_thread_methods.task1;

import java.util.ArrayList;

/**
 * Напишите программу из 10 последовательно запускающихся потоков.
 * Каждый из этих потоков должен выводить в консоль сообщение вида
 * «%Имя потока% запущен и не спешит», вызывать yield(),
 * а после выводить сообщение «%Имя потока% завершен».
 * <p>
 * Обратите внимание на порядок вывода. Как он изменится, если убрать yield()?
 * Как изменится ситуация, если паре потоков выставить приоритет 10?
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Thread> threads=new ArrayList<>(10);
        Runnable task=()->{
            System.out.println(Thread.currentThread().getName()+" запущен и не спешит");
            //Thread.yield();
            System.out.println(Thread.currentThread().getName()+" завершен");  
        };
        threads.add(new Thread(task, "Поток 0"));
        threads.add(new Thread(task, "Поток 1"));
        threads.add(new Thread(task, "Поток 2"));
        threads.add(new Thread(task, "Поток 3"));
        threads.add(new Thread(task, "Поток 4"));
        threads.add(new Thread(task, "Поток 5"));
        threads.add(new Thread(task, "Поток 6"));
        threads.add(new Thread(task, "Поток 7"));
        threads.add(new Thread(task, "Поток 8"));
        threads.add(new Thread(task, "Поток 9"));
        threads.get(8).setPriority(7);
        threads.get(9).setPriority(7);
        for (Thread thread : threads) {
            thread.start();
        }
    }
}