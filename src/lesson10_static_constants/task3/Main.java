package lesson10_static_constants.task3;

import java.util.Scanner;

/**
 * Используя задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson7_varargs_overloading/Task5.java">...</a>
 * (можете сделать на основе своего решения,
 * но для наглядности удобства новых возможностей рекомендую взять за основу решение по ссылке):
 * <p>
 * 1. Вынесите поиск простых чисел в отдельный класс.
 * <p>
 * 2. Реализуйте возможность вывода на экран суммы N первых простых чисел,
 * где N – число, введенное пользователем с клавиатуры;
 * <p>
 * 3. Вынесите нужные вам переменные в поля класса.
 * Если необходимо – сделайте их константами уровня класса или объекта.
 * Помните, константа ссылочного типа гарантирует неизменность ссылки, а не содержимого объекта.
 * Массив – ссылочный тип.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount of prime numbers: ");
        int numbersLimit = scanner.nextInt();

        scanner.close();

        PrimeNumbersFinder primeNumbersFinder = new PrimeNumbersFinder(numbersLimit);
        int[] primeNumbers = primeNumbersFinder.findPrimeNumbers();

        System.out.println(sum(primeNumbers));
    }

    static int sum(int[] numbers) {
        return sum(numbers, 0);
    }

    static int sum(int[] numbers, int i) {
        if (i == numbers.length - 1) {
            return numbers[i];
        }

        return numbers[i] + sum(numbers, i + 1);
    }
}
