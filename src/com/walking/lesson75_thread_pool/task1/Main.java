package com.walking.lesson75_thread_pool.task1;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Реализуйте программу, которая выводит актуальное время каждую минуту,
 * начиная с текущего момента.
 * Не используйте Thread.sleep() или циклы.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ScheduledExecutorService scheduler=Executors.newSingleThreadScheduledExecutor();
        var task=scheduler.scheduleAtFixedRate(()->{System.out.println(LocalTime.now());}, 0, 1, TimeUnit.MINUTES);
        while (!scanner.nextLine().equals("exit")) {
            
        }
        scanner.close();
        task.cancel(false);
        scheduler.close();
    }
}