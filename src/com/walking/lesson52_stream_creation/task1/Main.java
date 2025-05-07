package com.walking.lesson52_stream_creation.task1;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Реализуйте задачу 5.1 из урока 4:
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson4_cycles/Task5Var1.java">...</a>
 * используя Stream API.
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int randomInt = random.nextInt(1, 10);

        Scanner systemScanner = new Scanner(System.in);

        System.out.println("Угадайте число:");

        guessNumber(randomInt, systemScanner);
        guessNumberAlternative(randomInt, systemScanner);
    }

    private static void guessNumber(int number, Scanner scanner) {
        Stream.generate(scanner::nextInt)
              .takeWhile(i -> i != number)
              .forEach(s -> System.out.println("Не угадал"));
    }

    private static void guessNumberAlternative(int number, Scanner scanner) {
        scanner.tokens()
               .map(s -> Integer.toString(number)
                                .equals(s) ? "Угадал" : "Не угадал")
               .peek(System.out::println)
               .anyMatch("Угадал"::equals);
    }
}
