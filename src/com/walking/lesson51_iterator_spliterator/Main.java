package com.walking.lesson51_iterator_spliterator;

import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

/**
 * Реализовать Stream на основе System.in.
 * Операции в самом Stream’е можете описать на свой вкус.
 * Главное, разберитесь, когда будет запускаться обработка элементов
 * и в каком порядке она будет происходить.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Spliterator<String> spliterator = Spliterators.spliterator(in, 0, 0);

        StreamSupport.stream(spliterator, false)
                .limit(10)
                .map(Integer::parseInt)
                .map(n -> (n % 2 == 0) ? "чётное" : "нечётное")
                .forEach(System.out::println);
    }
}
