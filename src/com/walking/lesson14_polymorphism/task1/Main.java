package com.walking.lesson14_polymorphism.task1;

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
import com.walking.lesson14_polymorphism.task1.model.Square;
import com.walking.lesson14_polymorphism.task1.model.Triangle;

import java.util.Scanner;

public class Main {
    static void main() {
        new Main().run();
    }

    private void run(){
        try(Scanner input = new Scanner(System.in)) {

            System.out.print("Нажмите 1 для рисования квадрата или 2 для рисования треугольника: ");
            byte shapeVariant = input.nextByte();

            switch(shapeVariant)
            {
                case 1:
                    // Квадрат
                    System.out.print("Укажите длину стороны квадрата: ");
                    Square square = new Square(input.nextInt());
                    square.drawShape();
                    break;
                case 2:
                    // Треугольник
                    System.out.print("Укажите длину боковой стороны треугольника: ");
                    Triangle triangle = new Triangle(input.nextInt());
                    triangle.drawShape();
                    break;
                default:
                    System.out.println("Неизвестный тип фигуры");
                    break;
            }
        }
    }
}
