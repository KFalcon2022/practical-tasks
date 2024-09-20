package com.walking.lesson38_comparing.task2;

import com.walking.lesson38_comparing.task2.model.Car;
import com.walking.lesson38_comparing.task2.model.ColorType;
import com.walking.lesson38_comparing.task2.model.MarkType;

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
        List<Car> cars = initCars();
        printCar(cars);
        System.out.println("-----------------");

        cars.sort(Comparator.naturalOrder());
        printCar(cars);
        System.out.println("-----------------");

        cars.sort(Comparator.reverseOrder());
        printCar(cars);
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(MarkType.MAZDA, ColorType.YELOW, 2007, "674927"));
        cars.add(new Car(MarkType.RENAULT, ColorType.GREEN, 2003, "674923"));
        cars.add(new Car(MarkType.KIA, ColorType.WHITE, 2006, "674926"));
        cars.add(new Car(MarkType.AUDI, ColorType.BLACK, 2001, "674921"));
        cars.add(new Car(MarkType.BMW, ColorType.BLUE, 2002, "674922"));
        cars.add(new Car(MarkType.LADA, ColorType.RED, 2004, "674924"));
        cars.add(new Car(MarkType.VOLVO, ColorType.GREY, 2005, "674925"));
        cars.add(new Car(MarkType.SUZUKI, ColorType.RED, 2008, "674928"));
        cars.add(new Car(MarkType.LADA, ColorType.BLUE, 2009, "674929"));

        return cars;
    }

    public static void printCar(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
