package com.walking.lesson60.task1;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
