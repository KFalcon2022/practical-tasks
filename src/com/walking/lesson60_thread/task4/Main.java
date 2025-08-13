package com.walking.lesson60_thread.task4;

import com.walking.lesson60_thread.task4.model.FunctionExecutor;

import java.util.Random;

/**
 * Решите Задачу 3, не используя Thread.join().
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        FunctionExecutor<String, Integer> lengthCalculator = new FunctionExecutor<>("Test_string", String::length);

        System.out.println(lengthCalculator.call());

        FunctionExecutor<String, String> toUpperCase = new FunctionExecutor<>("Test_string", String::toUpperCase);

        System.out.println(toUpperCase.call());

        FunctionExecutor<Integer, String> oddOrEvenPrinter = new FunctionExecutor<>(new Random().nextInt(10),
                i -> i % 2 == 0 ? "%s is even".formatted(i) : "%s is odd".formatted(i));

        System.out.println(oddOrEvenPrinter.call());
    }
}