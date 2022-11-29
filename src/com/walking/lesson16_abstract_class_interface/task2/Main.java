package com.walking.lesson16_abstract_class_interface.task2;

import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        
        String input = SCANNER.nextLine();
        
        Printable message;
        
        // Честно говоря, не уверен, что понял идею использования интерфейса в этом задании
        switch (input){
            case "Hi":
                message = new HiMessage();
                break;
            
            case "Bye":
                message = new ByeMessage();
                break;

            case "How are you":
                message = new HowAreYouMessage();
                break;

            default:
                message = new DefaultMessage();
        }
        
        message.print();
        SCANNER.close();
        
    }
}