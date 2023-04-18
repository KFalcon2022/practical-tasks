package com.walking.lesson64.Task1;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread tmp = new Thread(() -> {
                System.out.println("%s запущен и не спешит".formatted(Thread.currentThread().getName()));
                //Thread.currentThread().yield();
                System.out.println("%s завершен".formatted(Thread.currentThread().getName()));
            });
            tmp.setName("MyThread%02d".formatted(i));
            if (i % 4 == 0) {
                tmp.setPriority(10);
            }
            tmp.start();
        }
    }
}
