package com.walking.lesson62_wait_notify.task1.service;

import java.util.Scanner;

public class MessageService {
    private String message;

    private final Scanner scanner = new Scanner(System.in);

    public String getInputMessage() {
        System.out.print("\nEnter your message: ");
        message = scanner.nextLine();

        return message;
    }

    public void close() {
        scanner.close();
    }
}
