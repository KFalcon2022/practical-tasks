package com.walking.lesson17_enum.task3;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Select available geometric figure from list: \n" +
                                                            "1.Triangle\n" +
                                                            "2.Square");
        Scanner sc = new Scanner(System.in);
        int figureType = sc.nextInt();
        System.out.print("Enter side length of figure: ");
        int sideLength = sc.nextInt();
        sc.close();

        switch (figureType) {
            case 1:
                System.out.println(EquilateralShape.EQUILATERAL_TRIANGLE.createShape(sideLength));
                break;
            case 2:
                System.out.println(EquilateralShape.SQUARE.createShape(sideLength));
                break;
            default:
                System.err.println("Unknown figure!");
        }
    }
}
