package com.walking.lesson20_exceptions.task2;

import com.walking.lesson20_exceptions.task2.exceptions.InputValidationException;
import com.walking.lesson20_exceptions.task2.shapes.*;

import java.util.Scanner;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 *
 * Использую задачу 1-1 (абстрактный класс) из урока 16:
 * Пользователь вводит с клавиатуры длину стороны и тип фигуры,
 * в консоль выводится эта фигура
 */
public class Main {
    public static void main(String[] args) {
        try {
            RightShape shapeToDraw = createFigure(selectShape(), selectSize());
            shapeToDraw.drawShape();
        }
        catch(InputValidationException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getInputValue());
        }
    }

    private static RightShape createFigure(int shapeType, int sideSize){
        switch (shapeType) {
            case (1) -> {
                return new TriangleShape(sideSize);
            }
            case (2) -> {
                return new SquareShape(sideSize);
            }
        }
        System.out.println("Something wrong in program...");
        return null;
    }
    private static int selectShape() {
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Please, select shape to draw (only 1 or 2) and press enter");
        System.out.println("\n");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.print("\nYour choice: ");
        int choice=scannerIn.nextInt();
        if (choice!=1&&choice!=2) {
            throw new InputValidationException("You entered wrong type of shape.",choice);
        }
        return choice;
    }

    private static int selectSize(){
        Scanner scannerIn=new Scanner(System.in);
        System.out.print("Enter the size of the shape's side: ");
        int size = scannerIn.nextInt();
        scannerIn.close();
        return size;
    }
}
