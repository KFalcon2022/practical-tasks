package com.walking.lesson50_streamAPI.task2;

import java.util.stream.Stream;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---practice
 * Переписать с помощью Stream метод, который получает массив строк
 * и возвращает сумму количества букв во всех словах,
 * которые длиннее 5 знаков
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("aaabba","bbbaattt","rr")); //6+8=14
    }
    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Stream.of(names)
                .mapToInt(String::length)
                .filter(x->x>5)
                .sum();
    }

}
