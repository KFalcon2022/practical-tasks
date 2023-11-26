package com.walking.lesson43_map.task2;
import com.walking.lesson43_map.task2.model.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Реализуйте класс «Машина». Поля допустимо выбрать на свое усмотрение, но необходимо,
 * чтобы по ним можно было однозначно идентифицировать каждую машину.
 * Скажем, в рамках базы ГАИ.
 * <p>
 * Создайте массив машин. Реализуйте максимально эффективную проверку на вхождение машины в ваш массив.
 * Данные для проверки необходимо запрашивать с клавиатуры.
 * <p>
 * Если машина найдена — выведите ее строковое представление в консоль.
 * <p>
 * Опциональное усложнение: номер машины может быть не уникальным.

 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods">...</a>,
 * используя Map.
 * Реализацию выберите исходя из особенностей исходной задачи.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Car> cars = initCars();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input car number for search: ");
        String search = sc.nextLine();
        sc.close();

        if (cars.containsKey(search)){
            System.out.println(cars.get(search));
        }else {
            System.out.println("Car not found!");
        }
    }



    private static Map<String, Car> initCars() {
        Map<String, Car> cars = new HashMap<>();
        cars.put("RR-111-RR", new Car("RR-111-RR", 2015, "yellow", true));
        cars.put("RR-222-RR", new Car("RR-222-RR", 2016, "yellow", true));
        cars.put("RR-333-RR", new Car("RR-333-RR", 2017, "yellow", true));
        cars.put("RR-444-RR", new Car("RR-444-RR", 2018, "yellow", true));
        cars.put("RR-555-RR", new Car("RR-555-RR", 2018, "yellow", true));
        cars.put("RR-666-RR", new Car("RR-666-RR", 2018, "yellow", true));
        cars.put("RR-777-RR", new Car("RR-777-RR", 2018, "yellow", true));
        cars.put("RR-888-RR", new Car("RR-888-RR", 2018, "yellow", true));
        cars.put("RR-999-RR", new Car("RR-999-RR", 2018, "yellow", true));
        cars.put("RR-000-RR", new Car("RR-000-RR", 2018, "yellow", true));

        return cars;
    }
}
