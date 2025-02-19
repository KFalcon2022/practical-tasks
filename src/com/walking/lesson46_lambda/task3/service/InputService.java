package com.walking.lesson46_lambda.task3.service;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner = new Scanner(System.in);

    public String getInput() {
       return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
