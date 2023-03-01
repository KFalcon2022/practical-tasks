package com.walking.lesson52_stream.Task1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Stream.generate(SCANNER::nextInt)
                .takeWhile(i -> i != 1)
                .forEach(i -> System.out.println("Не угадал!"));
    }
}
