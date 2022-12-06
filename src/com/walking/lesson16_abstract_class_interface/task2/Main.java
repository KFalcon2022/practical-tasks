package com.walking.lesson16_abstract_class_interface.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();

        switch (a) {
            case "Hi":
                System.out.println((new MessageHi()).getMessage());
                break;
            case "Bye":
                System.out.println((new MessageBye().getMessage()));
                break;
            case "How are you":
                System.out.println((new MessageHowAreYou()).getMessage());
                break;
            default:
                System.out.println((new MessageDefault()).getMessage());
                break;
        }
    }
}