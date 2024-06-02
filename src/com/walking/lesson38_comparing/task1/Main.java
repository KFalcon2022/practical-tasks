package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.CarComparator.CarNumberComparator;
import com.walking.lesson38_comparing.task1.CarComparator.CarYearComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>
 * реализуйте сортировку машин по:
 * · Номеру;
 * · Цвету;
 * · Году;
 * · Номеру и году.
 * <p>
 * Используйте список для хранения и сортировки коллекции машин.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("BMW", "8765", 2007, "Grey", true));
        carList.add(new Car("Toyota", "6532", 1994, "White", false));
        carList.add(new Car("Renault", "6532", 1990, "White", false));
        carList.add(new Car("Toyota", "1278", 2024, "Black", true));

        carList.sort(new CarNumberComparator().thenComparing(new CarYearComparator()));

        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
