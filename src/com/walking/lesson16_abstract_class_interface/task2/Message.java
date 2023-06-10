package com.walking.lesson16_abstract_class_interface.task2;

public class Message implements Printable{
    private final String helloMessage = "Hello!";
    private final String byeMessage = "Good bye!";
    private final String askMessage = "How are your doing?";

    @Override
    public void print(String str) {
        switch (str) {
            case "Hi":
                str = helloMessage;
                break;
            case "Bye":
                str = byeMessage;
                break;
            case "How are you":
                str = askMessage;
                break;
            default:
                str = "Unknown message";
        }
        System.out.println(str);
    }
}
