package com.walking.lesson50_streamAPI.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/streams---micro-katas
 * Суммируйте все элементы коллекции
 * Попробуйте использовать оператор reduce с параметром идентичности вместо IntStream
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(7);
        numbers.add(0);
        numbers.add(9);
        numbers.add(1);

        System.out.println(calculate(numbers)); //22
    }
    public static int calculate(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0,(a,b)->a+b);
        //или
                //.reduce(0, Integer::sum);
        //или
                //.reduce(Integer::sum)
                //.orElseThrow();
    }
    //Исходный код
//    public static int calculate(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            total += number;
//        }
//        return total;
//    }
}
