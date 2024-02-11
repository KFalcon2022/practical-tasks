package com.walking.lesson52_stream_creation.task1;

/**
 * Реализуйте задачу 5.1 из урока 4:
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson4_cycles/Task5Var1.java">...</a>
 * используя Stream API.
 */

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Выводить на экран "Не угадал!" до тех пор,
 * пока с клавиатуры не будет введено число 1.
 * Запрашивать число с клавиатуры перед выводом на экран "Не угадал!"
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stream.generate(()->Integer.valueOf(scanner.nextLine()))
                .takeWhile(x->x!=1)
                .forEach(a-> System.out.println("Не угадал!"));

        scanner.close();
    }
}
