package com.walking.lesson2_operators_console_io;

/**
 * Введите с клавиатуры вещественные числа a и b. Выведите на экран результат выражения
 * c = b*a*(a + b)/(a2),         где a2 - a в квадрате
 * Совпадает ли результат выражения, если a и b — переменные типа int
 * (для проверки не забудьте также использовать подходящий метод Scanner)?
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите b: ");
        double b = scanner.nextDouble();

        scanner.close();

        double c = b * a * (a + b) / (a * a);
        System.out.println("с: " + c);

        int aInt = (int) a;
        int bInt = (int) b;
        int cInt = bInt * aInt * (aInt + bInt) / (aInt * aInt);
        System.out.println("cInt: " + cInt);

        if (c == cInt) {
            System.out.println("Результат совпадает");
        } else {
            System.out.println("Результат различается");
        }
    }
}
