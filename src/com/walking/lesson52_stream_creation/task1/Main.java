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

//        Также можно сделать через стрим на основании System.in (см. реализацию в lesson51_iterator_spliterator).
//        Но тогда условие в takeWhile следует заменить на str - > !"1".equals(str).
//        Обратите внимание, что стрим на базе System.in в любой из предложенных реализаций параметризован типом String
//        (и итератор в Scanner, и lines() в BufferedReader работают со строковыми данными)
        Stream.generate(scanner::nextInt)
                .takeWhile(i -> i != 1) // до тех пор, пока введенное число != 1
                .forEach(it -> System.out.println("Не угадал!")); // выводить в консоль "Не угадал!"

        scanner.close();
    }
}
