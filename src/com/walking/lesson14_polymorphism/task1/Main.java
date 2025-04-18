package com.walking.lesson14_polymorphism.task1;

import com.walking.lesson14_polymorphism.task1.model.Square;
import com.walking.lesson14_polymorphism.task1.model.Triangle;

import java.util.Scanner;

/*
Реализуйте класс «Правильная фигура».
Для него создайте классы-наследники `Треугольник` и `Квадрат`.

Пользователь должен иметь возможность ввести длину стороны и выбрать тип фигуры.
Программа должна нарисовать в консоли выбранную пользователем фигуру,
используя символы `'-'`, `'|'`, `'/'`, `'\'`.

Обратите внимание, символ `'\'` в Java необходимо экранировать: `'\\'.`

 */
public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        int figure = requireInt(("""
                1. Triangle
                2. Square
                
                Make your choice: """));

        int width = requireInt("Enter a width: ");

        switch (figure) {
            case 1:
                new Triangle(width).printFigure();
                break;
            case 2:
                new Square(width).printFigure();
                break;
            default:
                System.out.println("Unknown figure");
        }
    }

    public static int requireInt(String message) {
        System.out.print(message);
        return SCANNER.nextInt();
    }
}
