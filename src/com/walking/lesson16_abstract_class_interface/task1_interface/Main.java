package com.walking.lesson16_abstract_class_interface.task1_interface;


import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * используя интерфейс.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massage: ");
        String massage = in.nextLine();

        switch (massage) {
            case Hello.MASSAGE:
                Hello.print();
                break;
            case Goodbye.MASSAGE:
                Goodbye.print();
                break;
            case How.MASSAGE:
                How.print();
                break;
            default: Printer.print();
        }
    }
}
