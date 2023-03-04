package com.walking.lesson51_iterator_spliterator;

import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

//        0 - отсутствие заданных характеристик. В данном случае мы можем утверждать, что порядок гарантирован
//        и элементы не могут быть null. Поэтому 0 можно заменить на Spliterator.ORDERED | Spliterator.NONNULL
//        (см. логическое сложение)
        Spliterator<String> scannerIterator = Spliterators.spliteratorUnknownSize(scanner, 0);

        StreamSupport.stream(scannerIterator, false)
                .limit(5)   // возьмем первые пять значений, введенных с клавиатуры
                .forEach(System.out::println);  //и выведем их в консоль

        scanner.close();

//        Реализация с помощью BufferedReader
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            reader.lines()
//                    .limit(5)
//                    .forEach(System.out::println);
//        }
    }
}
