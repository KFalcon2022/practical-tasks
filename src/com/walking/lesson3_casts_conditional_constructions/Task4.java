package com.walking.lesson3_casts_conditional_constructions;

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
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = scanner.nextInt();

        System.out.print("Введите b: ");
        int b = scanner.nextInt();

        scanner.close();

        if (a % 2 == 0 || b % 3 == 0) {
            if (a == b) {
                System.out.println("a = b");
            } else {
                System.out.println("a != b");
            }
        }
        if (a % 6 == 0) {
            System.out.print("a ^ b = ");
            double result = Math.pow(a, b);
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                System.out.println("Результат выражения слишком большой!");
            } else {
                System.out.println((int) result);
            }
        }
    }
}
