package com.walking.lesson51_iterator_spliterator;

import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.*;

/**
 * Реализовать Stream на основе System.in.
 * Операции в самом Stream’е можете описать на свой вкус.
 * Главное, разберитесь, когда будет запускаться обработка элементов
 * и в каком порядке она будет происходить.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(scanner, ORDERED & IMMUTABLE & NONNULL);

        Stream<String> stringStream = StreamSupport.stream(spliterator, false);

        System.out.println("Введите символ (для завершения введите x):");

        stringStream.peek(s -> System.out.println("Количество сиволов - " + s.length()))
                    .filter("x"::equals)
                    .findFirst()
                    .ifPresentOrElse(String::length, scanner::close);

        System.out.println("Введите 3 числа:");

        int sum = scanner.tokens()
                         .filter(s -> s.matches("^\\d+$"))
                         .limit(3)
                         .mapToInt(Integer::parseInt)
                         .sum();

        System.out.printf("Сумма введенных чисел = %s", sum);
    }
}
