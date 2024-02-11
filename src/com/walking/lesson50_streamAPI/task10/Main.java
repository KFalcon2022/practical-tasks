package com.walking.lesson50_streamAPI.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Напишите метод, который возвращает строку, разделенную запятыми, на основе заданного списка целых чисел.
 * Каждому элементу должна предшествовать буква «e», если число четное, и буква «o», если число нечетное.
 * Например, если входной список (3,44), выход должен быть 'o3,e44'.
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(202);

        System.out.println(getString(list));
    }
    public static String getString(List<Integer> list){
        return list.stream()
                .map(Optional::ofNullable)
                .map(
                        o-> o.filter(x->x%2==0)
                            .map(String::valueOf)
                            .map(s->"e"+s)
                        .or(()->o.filter(x->x%2!=0)
                            .map(String::valueOf)
                            .map(s->"o"+s))
                            .orElseThrow())
                .reduce(((s1,s2)->s1+", "+s2))
                .orElseThrow();

    }
}
