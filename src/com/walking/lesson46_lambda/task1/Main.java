package com.walking.lesson46_lambda.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Реализуйте
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson38_comparing/task1">Задачу 1 из урока 38</a>
 * описывая компараторы как лямбда-выражения.
 * * реализуйте сортировку машин по:
 * * · Номеру;
 * * · Цвету;
 * * · Году;
 * * · Номеру и году.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("BMW", "8765", 2007, "Grey", true));
        carList.add(new Car("Toyota", "6532", 1994, "White", false));
        carList.add(new Car("Renault", "6532", 1990, "White", false));
        carList.add(new Car("Toyota", "1278", 2024, "Black", true));

        Comparator<Car> numberComparator = Comparator.comparing(Car::getCarNumber);
        Comparator<Car> colorComparator = Comparator.comparing(Car::getColor);
        Comparator<Car> yearComparator = Comparator.comparing(Car::getYear);

        carList.sort(numberComparator.thenComparing(yearComparator));
        carList.forEach(System.out::println);
    }
}
