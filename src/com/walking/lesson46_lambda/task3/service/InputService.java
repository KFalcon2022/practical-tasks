package com.walking.lesson46_lambda.task3.service;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner = new Scanner(System.in);

    public String getLine() {
        return scanner.nextLine();
    }

    public void destroy() {
        scanner.close();
    }
}
