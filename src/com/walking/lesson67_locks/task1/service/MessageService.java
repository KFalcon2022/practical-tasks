package com.walking.lesson67_locks.task1.service;

import java.util.Scanner;

public class MessageService {
    private final Scanner scanner;

    public MessageService() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        System.out.print("\nEnter message: ");
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
