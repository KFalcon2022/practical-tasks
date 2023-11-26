package com.walking.lesson46_lambda.task1;

import com.walking.lesson38_comparing.task1.model.*;
import java.util.*;

/**
 * Реализуйте
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson38_comparing/task1">Задачу 1 из урока 38</a>
 * описывая компараторы как лямбда-выражения.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = initCars();
        System.out.println("_________________NOT SORTED_________________");
        printAllCars(cars);


        cars.sort(Comparator.comparing(car -> car.getIdentifier()
                .getNumber()));
        System.out.println("_________________SORTED BY NUMBER_________________");
        printAllCars(cars);


        cars.sort(Comparator.comparing(Car::getColor));
        System.out.println("_________________SORTED BY COLOR_________________");
        printAllCars(cars);


        cars.sort(Comparator.comparing(car -> car.getIdentifier()
                .getYear()));
        System.out.println("_________________SORTED BY YEAR_________________");
        printAllCars(cars);


        Comparator<Car> carNumberComparator = Comparator.comparing(car -> car.getIdentifier()
                .getNumber());

        Comparator<Car> carYearComparator = Comparator.comparing(car -> car.getIdentifier()
                .getYear());

        /*  Не понял как сделать одним выражением - сделал 2 компаратора.
          Потом пришло понимание, что мог создать все компараторы после инициализации списка
          вначале main и использовать нужный(е), но оставил так*/

        cars.sort(carNumberComparator.thenComparing(carYearComparator));
        System.out.println("_________________NUMBER AND YEAR_________________");
        printAllCars(cars);

    }



    private static ArrayList<Car> initCars() {
        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("A111AA", 2012, "white", true));
        cars.add(new Car("B222BB", 2019, "black", true));
        cars.add(new Car("C333CC", 2018, "yellow", true));
        cars.add(new Car("A123AB", 2022, "red", false));
        cars.add(new Car("C321BA", 2021, "purple", true));
        cars.add(new Car("A213AB", 1998, "blue", true));
        cars.add(new Car("B231BA", 2017, "green", false));
        cars.add(new Car("B331CA", 2012, "brown", true));
        cars.add(new Car("C112CA", 2020, "grey", true));
        cars.add(new Car("C322AC", 2018, "multicolor", true));
        cars.add(new Car("A313CA", 2012, "white", true));
        cars.add(new Car("B113AB", 2010, "pink", false));

        return cars;
    }

    private static void printAllCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car + "\n");
        }
    }

}
