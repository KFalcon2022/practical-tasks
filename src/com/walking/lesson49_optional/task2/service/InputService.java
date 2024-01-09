package com.walking.lesson49_optional.task2.service;

public class InputService extends com.walking.lesson49_optional.task1.service.InputService {
    public static int getYear(){
        System.out.print("Enter car release year: ");
        return scanner.nextInt();
    }
}
