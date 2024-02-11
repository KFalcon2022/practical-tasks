package com.walking.lesson50_streamAPI.task1;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---intro
 * С помощью Stream преобразовать массив строк в коллекцию тех же строк, но в верхнем регистре
 * Вернуть из метода
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(mapToUppercase("aaa","bbb","ccc"));
    }
    // Исходный метод
//    public static Collection<String> mapToUppercase(String... names) {
//        Collection<String> uppercaseNames = new ArrayList<>();
//        uppercaseNames= Stream.of(names)
//                .map(String::toUpperCase)
//                .collect(Collectors.toList());
//        return uppercaseNames;
//    }

    private static Collection<String> mapToUppercase(String ...names){
        return Stream.of(names)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
