package com.walking.lesson16_abstract_class_interface.task2;

import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        String question = requireMessage();
        SCANNER.close();

        Answer.compare(question);
    }

    private static String requireMessage() {
        return SCANNER.nextLine();
    }
}
