package com.walking.lesson38_comparing.task2;

import com.walking.lesson38_comparing.task2.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>,
 * имплементируйте Comparable для Car таким образом,
 * чтобы машины сравнивались по полю identifier.
 * Объекты CarIdentifier предлагаю сравнивать по номеру и году (если номера почему-то совпали).
 * <p>
 * Также реализуйте сортировку коллекции машин в прямом и обратном порядке.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> cars = createList();
        cars.sort(Comparator.naturalOrder());
        printList(cars);
    }

    public static ArrayList<Car> createList() {
        return new ArrayList<>(List.of(
                new Car("Audi", "Печкин Ф.Б.", "уе777к"),
                new Car("BMW", "Борисов Ю.А.", "ос025р"),
                new Car("Ford", "Снегирь Ю.В.", "мр666м"),
                new Car("Bentley", "Белова Д.М.", "ра345з"),
                new Car("Ferrari", "Сергеев К.Л.", "уе999з"),
                new Car("Москвич", "Попов А.Д.", "ар832с"),
                new Car("Audi", "Васильев П.Д.", "кв865а"),
                new Car("BMW", "Лебедев А.Ю.", "ау000ш"),
                new Car("Москвич", "Алексеев Л.Б.", "гн123г")));
    }

    public static void printList(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
