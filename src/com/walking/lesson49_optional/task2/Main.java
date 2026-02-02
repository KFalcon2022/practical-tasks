package com.walking.lesson49_optional.task2;

import com.walking.lesson49_optional.task2.model.Human;
import com.walking.lesson49_optional.task2.model.car.Car;
import com.walking.lesson49_optional.task2.model.car.CarIdentifier;
import com.walking.lesson49_optional.task2.service.CarService;
import com.walking.lesson49_optional.task2.service.AddressService;

import java.util.Scanner;

/**
 * Реализуйте рад классов:
 * 1. Жилье, должен иметь поле «адрес»;
 * 2. Человек. Поля – «имя», «мать», «отец», «дети», «жилье», «машина», «профессия»;
 * 3. Машина. Предлагаю взять реализацию из Задачи 1 и добавить к ней поле «владелец» типа «Человек».
 * Реализуйте поиск адреса проживания первого ребенка владельца машины с заданным номером и годом выпуска.
 * Используйте реализацию поиска машины из Задачи 1. Изменять ее под требования текущей задачи – недопустимо.
 * <p>
 * Поиск должен быть прекращен, если совпало хотя бы одно из условий:
 * · машина новее 2021 года;
 * · профессия владельца машины или его первого ребенка – «полицейский»;
 * · адрес проживания содержит подстроку «Рублевское шоссе».
 * <p>
 * В таких случаях ничего не должно быть найдено.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());
        CarIdentifier desiredCarIdentifier = createCar();
        AddressService addressService = new AddressService(carService);

        System.out.println(addressService.getAddress(desiredCarIdentifier));
    }

    private static CarIdentifier createCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's number");
        String number = scanner.nextLine();

        System.out.println("Enter a car's year");
        int year = scanner.nextInt();

        scanner.close();

        return new CarIdentifier(number, year);
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true, new Human("Bill"));
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true, new Human("Sam"));
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true, new Human("Tom"));
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true, new Human("Din"));
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true, new Human("Phil"));
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true, new Human("Chuck"));
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true, new Human("Don"));
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true, new Human("Bill"));
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true, new Human("Bill"));
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true, new Human("Bill"));

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
