package com.walking.lesson71_thread_safe_collections.task1;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentificator;
import com.walking.lesson61_synchronized.service.CarGeneratorService;
import com.walking.lesson71_thread_safe_collections.task1.service.CarService;

/**
 * Реализуйте Задачу из Урока 61,
 * используя потокобезопасные коллекции вместо механизма synchronized.
 *
 * @see com.walking.lesson61_synchronized.Main
 */
public class Main {
    public static void main(String[] args) {
        CarGeneratorService carGenerator = new CarGeneratorService();
        Car[] cars = carGenerator.createCarArray();

        CarService carService = new CarService();

        for (Car car : cars) {
            new Thread(() -> carService.add(car)).start();
        }

        System.out.println(carService.getCars());

        new Thread(() -> carService.delete(new Car(new CarIdentificator("RR-444-RR", 2018), "red"))).start();
        new Thread(() -> carService.delete(new Car(new CarIdentificator("RR-777-RR", 2018), "red"))).start();
        new Thread(() -> carService.delete(new Car(new CarIdentificator("RR-777-RR", 2018), "black"))).start();

        System.out.println(carService.getCars());

        new Thread(() -> carService.change(new Car(new CarIdentificator("RR-111-RR", 2015), "yellow"))).start();
        System.out.println(carService.getCars());

        new Thread(() -> carService.change(new Car(new CarIdentificator("RR-000-RR", 2018), "orange"))).start();
        System.out.println(carService.getCars());

        new Thread(() -> carService.change(new Car(new CarIdentificator("RR-666-RR", 2018), "black"))).start();
    }
}