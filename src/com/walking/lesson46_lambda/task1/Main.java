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
        ArrayList<Car> cars = new ArrayList<>(createList());
        sortByIdentifier(cars);
        printList(cars);
    }

    public static void sortByOwner(List<Car> cars) {
        cars.sort(getOwnerComparator());
    }

    public static void sortByNumber(List<Car> cars) {
        cars.sort(getNumberComparator());
    }

    public static void sortByBrand(List<Car> cars) {
        cars.sort(getBrandComparator());
    }

    public static void sortByIdentifier(List<Car> cars) {
        cars.sort(getBrandComparator().thenComparing(getNumberComparator()));
    }

    private static Comparator<Car> getNumberComparator() {
        return Comparator.comparing(o -> o.getIdentifier().getNumber());
    }

    private static Comparator<Car> getBrandComparator() {
        return Comparator.comparing(o -> o.getIdentifier().getBrand());
    }

    private static Comparator<Car> getOwnerComparator() {
        return Comparator.comparing(o -> o.getOwner());
    }

    public static List<Car> createList() {
        return List.of(
                new Car("Audi", "Печкин Ф.Б.", "уе777к"),
                new Car("BMW", "Борисов Ю.А.", "ос025р"),
                new Car("Ford", "Снегирь Ю.В.", "мр666м"),
                new Car("Bentley", "Белова Д.М.", "ра345з"),
                new Car("Ferrari", "Сергеев К.Л.", "уе999з"),
                new Car("Москвич", "Попов А.Д.", "ар832с"),
                new Car("Audi", "Васильев П.Д.", "кв865а"),
                new Car("BMW", "Лебедев А.Ю.", "ау000ш"),
                new Car("Москвич", "Алексеев Л.Б.", "гн123г"));
    }

    public static void printList(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
