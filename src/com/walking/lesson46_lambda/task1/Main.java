package com.walking.lesson46_lambda.task1;

import com.walking.lesson46_lambda.task1.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Реализуйте
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson38_comparing/task1">Задачу 1 из урока 38</a>
 * описывая компараторы как лямбда-выражения.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(initCars());
        print(cars);

        cars.sort(Comparator.comparing(o -> o.getCarIdentifier().getNumber()));
        print(cars);

        cars.sort(Comparator.comparing(Car::getColor));
        print(cars);

        cars.sort(Comparator.comparing(o -> o.getCarIdentifier().getYear()));
        print(cars);

        Comparator<Car> numberComparator = Comparator.comparing(o -> o.getCarIdentifier().getNumber());
        Comparator<Car> yearComparator = Comparator.comparing(o -> o.getCarIdentifier().getYear());
        cars.sort(yearComparator.thenComparing(numberComparator));
        print(cars);
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("RRR-111-XX", 2020, "red", true));
        cars.add(new Car("RRR-222-XX", 2021, "red", true));
        cars.add(new Car("RRR-333-XX", 2022, "blue", true));
        cars.add(new Car("RRR-444-XX", 2021, "red", true));
        cars.add(new Car("RRR-555-XX", 2023, "white", true));
        cars.add(new Car("RRR-666-XX", 2021, "white", true));
        cars.add(new Car("RRR-777-XX", 2020, "white", true));
        cars.add(new Car("RRR-888-XX", 2021, "red", true));
        cars.add(new Car("RRR-999-XX", 2020, "black", true));
        cars.add(new Car("RRR-000-XX", 2021, "black", true));

        return cars;
    }

    private static void print(List<?> cars) {
        cars.forEach(System.out::print);
    }
}
