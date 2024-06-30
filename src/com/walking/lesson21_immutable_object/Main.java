package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.service.CarService;

import java.util.Scanner;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());
        Car car = carService.foundCar(createCar());

        System.out.println(car);
        System.out.println(car.hashCode());
    }

    private static Car createCar () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter a car number: ");
        String number = scanner.nextLine();

        return new Car(model, number, 0, null);
    }

    private static Car[] initCars() {
        Car car1 = new Car("Tesla", "RRR-000-XX", 2015, "white");
        Car car2 = new Car("Audi", "RRR-111-XX", 2016, "black");
        Car car3 = new Car("VAZ", "RRR-222-XX", 2017, "pink");
        Car car4 = new Car("BMW", "RRR-333-XX", 2018, "blue");
        Car car5 = new Car("Tesla", "RRR-444-XX", 2019, "yellow");
        Car car6 = new Car("VAZ", "RRR-555-XX", 2020, "orange");
        Car car7 = new Car("Tesla", "RRR-666-XX", 2021, "gold");
        Car car8 = new Car("BMW", "RRR-777-XX", 2022, "silver");
        Car car9 = new Car("Aidi", "RRR-888-XX", 2023, "milk");
        Car car10 = new Car("Tesla", "RRR-999-XX", 2024, "red");

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
