package com.walking.lesson47_method_reference.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте Задачу 1, обернув метод выведения записи в консоль
 * (System.out.println()) в собственный статический метод.
 */
public class Main {
    public static void main(String[] args) {
        List<String> months = new ArrayList<>();

        months.add(new String("January"));
        months.add(new String("February"));
        months.add(new String("March"));
        months.add(new String("April"));
        months.add(new String("May"));
        months.add(new String("June"));
        months.add(new String("July"));
        months.add(new String("August"));
        months.add(new String("September"));
        months.add(new String("October"));
        months.add(new String("November"));
        months.add(new String("December"));

        months.forEach(Main::print);
    }

    private static void print(String month) {
        System.out.println(month);
    }
}
