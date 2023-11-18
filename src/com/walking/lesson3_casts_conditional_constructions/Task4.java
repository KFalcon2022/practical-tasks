package src.com.walking.lesson3_casts_conditional_constructions;

/**
 * Ввести с клавиатуры два целых числа.
 * Если первое – четное ИЛИ второе – кратно трем,
 * вывести в консоль результат сравнения этих чисел.
 * <p>
 * Если первое число кратно и двум, и трем – вывести на экран число один,
 * возведенное в степень N, где N – второе число.
 * Для возведения в степень можно использовать Math.pow().
 * В случае, если результат выражения выходит за пределы типа int
 * (допустимые значения - [-2147483648; 2147483647]) –
 * вывести сообщение «Результат выражения слишком большой!»
 * <p>
 * Также максимальное и минимальное значение int содержится в константах
 * Integer.MIN_VALUE и Integer.MAX_VALUE соответственно.
 */

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите второе чилсло: ");
        int b = scanner.nextInt();

        scanner.close();

        if (a % 2 == 0) {
            if (a > b) {
                System.out.println("Первое число больше второго");
            } else {
                System.out.println("Второе число больше первого");
            }

            if (a % 3 == 0) {
                if ((Math.pow(a, b) < Integer.MIN_VALUE) || (Math.pow(a, b) > Integer.MAX_VALUE)) {
                    System.out.println("Результат выражения слишком большой!");
                } else {
                    System.out.println("Первое число в степени второе число: " + (int) Math.pow(a, b));
                }
            }
        } else {
            if (b % 3 == 0) {
                if (a > b) {
                    System.out.println("Первое число больше второго");
                } else {
                    System.out.println("Второе число больше первого");
                }
            }
        }
    }
}
