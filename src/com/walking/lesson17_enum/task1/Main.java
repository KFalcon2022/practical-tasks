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
        switch (s) {
            case "Hi" :
                Answer.HI.getAnswer();
                break;

            case "Bye" :
                Answer.BYE.getAnswer();
                break;

            case "How are you" :
                Answer.HOW.getAnswer();
                break;

            default:
                Answer.UNKNOWN.getAnswer();
        }
    }

}
