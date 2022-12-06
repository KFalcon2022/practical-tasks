package com.walking.lesson16_abstract_class_interface.task1interface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isExit = false;

        while(!isExit) {
            System.out.println("1 - квадрат\n2 - треугольник\n3 - выход");
            int input = in.nextInt();
            int length;
            switch (input) {
                case 1:
                    System.out.println("Введите длину");
                    length = in.nextInt();
                    Square s = new Square(length);
                    s.draw();
                    break;
                case 2:
                    System.out.println("Введите длину");
                    length = in.nextInt();
                    Triangle t = new Triangle(length);
                    t.draw();
                    break;
                case 3:
                    isExit = true;
            }
        }

    }
}
