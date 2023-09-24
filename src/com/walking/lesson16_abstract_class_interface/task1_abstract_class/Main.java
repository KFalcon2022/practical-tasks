package com.walking.lesson16_abstract_class_interface.task1_abstract_class;

import com.walking.lesson16_abstract_class_interface.task1_abstract_class.shapes.RightShape;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.shapes.SquareShape;
import com.walking.lesson16_abstract_class_interface.task1_abstract_class.shapes.TriangleShape;

import java.io.IOException;
import java.util.Scanner;

/**Реализуйте класс «Правильная фигура». Для него создайте классы-наследники «Треугольник» и «Квадрат».
 Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
 Программа должна нарисовать в консоли выбранную пользователем фигуру, используя символы '-', '|', '/', '\'.
 Обратите внимание, символ '\' в Java необходимо экранировать: '\\'.
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        createFigure(selectShape(),selectSize()).drawShape();
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
    private static int selectShape() throws IOException {
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Please, select shape to draw (only 1 or 2) and press enter");
        System.out.println("\n");
        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.print("\nYour choice: ");
        int choise=scannerIn.nextInt();
        if (choise!=1&&choise!=2) {
            System.out.println("You entered wrong number. Shape number "+choise+" doesn't exist!");
            throw new IOException();
        }
        return choise;
    }

    private static int selectSize(){
        Scanner scannerIn=new Scanner(System.in);
        System.out.print("Enter the size of the shape's side: ");
        int size = scannerIn.nextInt();
        scannerIn.close();
        return size;
    }
}
