package com.walking.lesson17_enum.task3;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task1">...</a>
 * через enum. Пусть EquilateralTriangle и Square будут значениями enum'а EquilateralShape.
 */

import java.util.Scanner;

/**
 * Реализуйте класс «Правильная фигура».
 * Для него создайте классы-наследники «Треугольник» и «Квадрат».
 * <p>
 * Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 * Программа должна нарисовать в консоли выбранную пользователем фигуру,
 * используя символы '-', '|', '/', '\'.
 * <p>
 * Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 */
public class Main {
    public static void main(String[] args) throws Exception {
       getShapeChoice().drawShape(getShapeLength());
    }
    private static EquilateralShape getShapeChoice()throws Exception{
        int choiceValue;
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Choose shape (1 or 2): ");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.print("Your choice: ");
        choiceValue=scannerIn.nextInt();
        return checkShapeChoice(choiceValue);
    }
    private static int getShapeLength(){
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("\nEnter length of the shape: ");
        int shapeLength=scannerIn.nextInt();
        scannerIn.close();
        return shapeLength;
    }
    private static EquilateralShape checkShapeChoice(int choiceValue) throws Exception{
        switch (choiceValue){
            case (1):
                System.out.println("You have chosen Triangle!");
                return EquilateralShape.EQUILATERAL_TRIANGLE;
            case (2):
                System.out.println("You have chose Square!");
                return EquilateralShape.SQUARE;
            default:
                System.out.println("You entered wrong value. This shape doesn't exist!");
                throw new Exception("The end.");
        }
    }
}
