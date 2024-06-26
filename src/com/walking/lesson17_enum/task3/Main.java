package com.walking.lesson17_enum.task3;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Select figure type: 1: Triangle, 2: Square");
        Scanner sc=new Scanner(System.in);
        int type=sc.nextInt();
        System.out.println("Insert length:");
        int length=sc.nextInt();
        sc.close();
        String out="";
        switch (type) {
            case 1:
                out=CorrectFigure.Triangle.printFigure(length);
                break;
            case 2:
                out=CorrectFigure.Square.printFigure(length);
                break;
            default:
                out="Wrong figure";
                break;
        }
        System.out.println(out);
    }
}
