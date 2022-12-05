package com.walking.lesson17_enum.task1;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        Message inputMessage = Message.getName(input);
        switch (inputMessage) {
            case HI -> System.out.println(Message.HI.outputMessage);
            case BYE -> System.out.println(Message.BYE.outputMessage);
            case HOW_ARE_YOU -> System.out.println(Message.HOW_ARE_YOU.outputMessage);
            case DEFAULT -> System.out.println(Message.DEFAULT.outputMessage);

        }
    }
}
