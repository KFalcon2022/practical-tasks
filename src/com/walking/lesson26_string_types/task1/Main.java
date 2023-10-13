package com.walking.lesson26_string_types.task1;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson6_methods/Task3.java">...</a>
 * используя StringBuilder или StringBuffer. Объясните свой выбор.
 */

import com.walking.lesson26_string_types.task1.service.Rectangle;

import java.util.Scanner;

/**
 * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа).
 * Нарисовать в консоли заданный прямоугольник, используя “-“ и “|”.
 * Углы прямоугольника обозначить символом “ “.
 * Каждая единица длины должна обозначаться одним символом “-“,
 * каждая единица ширины – символом “|“.
 * <p>
 * Произвести декомпозицию по своему усмотрению. Рекомендую скинуть на проверку. Контакт ниже.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("Enter length: ");
        int length = scannerIn.nextInt();
        System.out.print("\nEnter width: ");
        int width = scannerIn.nextInt();

        scannerIn.close();

        Rectangle rectangle = new Rectangle(length, width);
        System.out.println(rectangle.createRectangle());

    }
}
