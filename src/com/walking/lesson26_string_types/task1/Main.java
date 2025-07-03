package com.walking.lesson26_string_types.task1;

import com.walking.lesson26_string_types.task1.service.Rectangle;
import com.walking.lesson26_string_types.task1.service.UnexpectedNumberException;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson6_methods/Task3.java">...</a>
 * используя StringBuilder или StringBuffer. Объясните свой выбор.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = getNumber(in, "Введите длину: ");
        int width = getNumber(in, "Введите ширину: ");

        Rectangle rectangle = new Rectangle(length, width);
        System.out.println(rectangle.getRectangle());
    }

    public static int getNumber(Scanner in, String message) throws UnexpectedNumberException {
        System.out.print(message);
        int num = in.nextInt();

        if (num > 0) {
            return num;
        }

        throw new UnexpectedNumberException("Число должно быть больше 0");
    }
}
