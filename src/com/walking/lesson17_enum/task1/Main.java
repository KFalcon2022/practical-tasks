package com.walking.lesson17_enum.task1;

import java.util.Scanner;

import com.walking.lesson17_enum.task1.answer.Answer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        scanner.close();

        for (Answer value : Answer.values()) {
            if (s.equals(value.question)) {
                System.out.println(value.answer);
            }
        }
    }
}
