package com.walking.lesson20_exceptions.task2;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        String userChoice;
        byte userLength = 0;

        EquilateralShape shape;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your figure:");
        userChoice = reader.readLine().trim().toLowerCase(Locale.ROOT);
        System.out.print("Enter your length:");
        userLength = Byte.parseByte(reader.readLine());
        if (userLength <= 0 || userLength == Byte.MAX_VALUE) {
            throw new ShapeException("Wrong number", userLength);
        }
        shape = userChoice.contains("tria") ?
                new EquilateralTriangle(userLength) :
                (userChoice.contains("sqa") ?
                        new Square(userLength): null);
        if (shape == null)
        {
            System.out.println("Invalid shape");
        }
    }
}