package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.model.*;

import java.util.*;

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
        ArrayList<Car> cars = new ArrayList<>(createList());
        sortByIdentifier(cars);
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public static void sortByOwner(List<Car> cars) {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getOwner().compareTo(o2.getOwner());
            }
        });
    }

    public static void sortByNumber(List<Car> cars) {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getIdentifier().getNumber().compareTo(o2.getIdentifier().getNumber());
            }
        });
    }

    public static void sortByBrand(List<Car> cars) {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getIdentifier().getBrand().compareTo(o2.getIdentifier().getBrand());
            }
        });
    }

    public static void sortByIdentifier(List<Car> cars) {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int result = o1.getIdentifier().getBrand().compareTo(o2.getIdentifier().getBrand());
                if (result == 0) {
                    return o1.getIdentifier().getNumber().compareTo(o2.getIdentifier().getNumber());
                }
                return result;
            }
        });
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
}
