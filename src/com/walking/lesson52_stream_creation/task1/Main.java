package com.walking.lesson52_stream_creation.task1;

import java.util.Scanner;
import java.util.stream.Stream;


/**
 * Реализуйте задачу 5.1 из урока 4:
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson4_cycles/Task5Var1.java">...</a>
 * используя Stream API.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stream.generate(scanner::nextInt)
                .takeWhile(number -> number != 1)
                .forEach(number -> System.out.println("Didn't guess"));

        scanner.close();

    }
}
