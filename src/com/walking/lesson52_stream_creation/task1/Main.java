package com.walking.lesson52_stream_creation.task1;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Реализуйте задачу 5.1 из урока 4:
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson4_cycles/Task5Var1.java">...</a>
 * используя Stream API.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        IntStream.generate(scanner::nextInt)
        .takeWhile(i->i!=1)
        .forEach(i->System.out.println("Не угадал!"));
        scanner.close();
    }
}
