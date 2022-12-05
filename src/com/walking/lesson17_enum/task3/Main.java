package com.walking.lesson17_enum.task3;

import java.util.Scanner;

public class Main {
    public Main() {
    }

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
                    RegularShape s = RegularShape.Square;
                    s.draw(length);
                    break;
                case 2:
                    System.out.println("Введите длину");
                    length = in.nextInt();
                    RegularShape t = RegularShape.Triangle;
                    t.draw(length);
                    break;
                case 3:
                    isExit = true;
            }
        }

    }
}
