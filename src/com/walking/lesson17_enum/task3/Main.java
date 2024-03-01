package com.walking.lesson17_enum.task3;

import com.walking.lesson17_enum.task3.enums.EquiLateralShape;

import java.util.Scanner;


/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */
public class Main {
    public static void main(String[] args) {

        int size;
        int choice;

        Scanner io = new Scanner(System.in);

            System.out.println("Enter figure width");
            size = io.nextInt();
            System.out.println("Enter 1 for triangle, 2 for square");
            choice = io.nextInt();
        io.close();
        if (choice < 1 || choice > 2 || size < 1 || size > 20){
            System.out.println("Incorrect entry");
            return;
        }

        EquiLateralShape figure = switch (choice) {
            case 1 -> EquiLateralShape.TRIANGLE;
            default -> EquiLateralShape.SQUARE;
        };


        System.out.println(figure.drawFigure(size));
    }
}
