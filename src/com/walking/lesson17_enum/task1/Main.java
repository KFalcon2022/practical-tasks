package com.walking.lesson17_enum.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        scanner.close();
        sayAnswer(s);
    }
    static void sayAnswer(String s) {
        Answer answer;
        switch (s) {
            case "Hi":
                answer = Answer.HI;
                break;
            case "Bye":
                answer = Answer.BYE;
                break;
            case "How are you":
                answer = Answer.HOW;
                break;
            default: answer = Answer.UNKNOWN;
        }

        System.out.println(answer.getAnswer());
    }
}
