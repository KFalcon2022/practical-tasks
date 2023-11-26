package com.walking.lesson49_optional.task2;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentifier;
import com.walking.lesson49_optional.task2.model.Housing;
import com.walking.lesson49_optional.task2.model.Person;
import com.walking.lesson49_optional.task2.service.CarService;

import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private final static String PROFESSION_FILTER = "полицейский";

    public static void main(String[] args) {


        Housing housing = new Housing();
        housing.setAddress("address");

        Person child1 = new Person("child1");
        child1.setProfession("profession1");
        child1.setHousing(housing);

        Person child2 = new Person("child2");

        Person person = new Person("Person1");
        person.setProfession("profession1");
        person.addChildren(child1);
        person.addChildren(child2);

        CarService carService = new CarService(initCars());
        carService.findCar(new CarIdentifier("RR-111-RR", 2021)).ifPresent(car -> {
            car.setOwner(person);
            person.setCar(car);
        });


        getAddress(createCar(), carService).ifPresent(System.out::println);

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
        Car car1 = new Car("RR-111-RR", 2021, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }

    // Вообще первый ребенок это поиск по возрасту, но его у нас нет так что абстрагируемся от этого нюанса
    public static Optional<String> getAddress(CarIdentifier desiredCarIdentifier, CarService carService) {

        return carService.findCar(desiredCarIdentifier)
                .filter(car -> car.getIdentifier().getYear() <= 2021)
                .map(Car::getOwner)
                .filter(owner -> !PROFESSION_FILTER.equals(owner.getProfession()))
                .map(Person::getChildren)
                .filter(children -> !children.isEmpty())
                .map(children -> children.get(0))
                .filter(firstChild -> !PROFESSION_FILTER.equals(firstChild.getProfession()))
                .map(Person::getHousing)
                .map(Housing::getAddress)
                .filter(address -> !address.equals("Рублевское шоссе"));
    }
}
