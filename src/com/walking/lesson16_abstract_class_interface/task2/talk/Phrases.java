package com.walking.lesson16_abstract_class_interface.task2.talk;

public class Phrases implements Hi, Bye, How {
    public Phrases(String s) {
        print(s);
    }

    public void print(String s) {
        switch (s) {
            case "Hi":
                Hi.print();
                break;

            case "Bye":
                Bye.print();
                break;

            case "How are you":
                How.print();
                break;

            default:
                System.out.println("Unknown message");
        }
    }
}
