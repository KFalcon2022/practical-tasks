package com.walking.lesson60_thread.task4;

/**
 * Решите Задачу 3, не используя Thread.join().
 */
public class Main {
    public static void main(String[] args) {
        AnotherThreadResult<Integer> atr=new AnotherThreadResult<>();
        System.out.println(atr.getResult(()->5+1));
    }
}