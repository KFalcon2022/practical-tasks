package com.walking.lesson75_thread_pool.task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Реализуйте программу, которая сообщает о начале каждого часа.
 * Не используйте Thread.sleep() или циклы.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        LocalDateTime firstHour=LocalDateTime.of(LocalDate.now(), LocalTime.of(LocalTime.now().plusHours(1).getHour(), 0));
        ScheduledExecutorService scheduler=Executors.newSingleThreadScheduledExecutor();
        var task=scheduler.scheduleAtFixedRate(()->{System.out.println(LocalTime.now());},
        LocalDateTime.now().until(firstHour, ChronoUnit.MILLIS),
        3600000, TimeUnit.MILLISECONDS);
        while (!scanner.nextLine().equals("exit")) {
            
        }
        scanner.close();
        task.cancel(false);
        scheduler.close();
    }
    }