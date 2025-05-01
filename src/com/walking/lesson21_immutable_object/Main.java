package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.model.PersonalCar;
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

        PersonalCar desiredCar = createCar();
        PersonalCar foundCar = null;
        try {
            foundCar = carService.findCar(desiredCar);
            System.out.println(foundCar);
        } catch (CarFindException e) {
            System.out.println(e.getMessage());
        }
    }

    private static PersonalCar createCar() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a car's number: ");
        String number = scanner.nextLine();

        System.out.print("Enter a car's color: ");
        String color = scanner.nextLine();

        System.out.print("Enter a car's year: ");
        int year = scanner.nextInt();

        System.out.println("Enter a actuality of technical inspection: ");
        boolean actualTechnicalInspection = scanner.nextBoolean();

        scanner.close();

        return new PersonalCar(number, year, color, actualTechnicalInspection);
    }

    private static PersonalCar[] initCars() {
        PersonalCar car1 = new PersonalCar("RR-111-RR", 2015, "yellow", true);
        PersonalCar car2 = new PersonalCar("RR-222-RR", 2016, "yellow", true);
        PersonalCar car3 = new PersonalCar("RR-333-RR", 2017, "yellow", true);
        PersonalCar car4 = new PersonalCar("RR-444-RR", 2018, "yellow", true);
        PersonalCar car5 = new PersonalCar("RR-555-RR", 2018, "yellow", true);
        PersonalCar car6 = new PersonalCar("RR-666-RR", 2018, "yellow", true);
        PersonalCar car7 = new PersonalCar("RR-777-RR", 2018, "yellow", true);
        PersonalCar car8 = new PersonalCar("RR-888-RR", 2018, "yellow", true);
        PersonalCar car9 = new PersonalCar("RR-999-RR", 2018, "yellow", true);
        PersonalCar car10 = new PersonalCar("RR-000-RR", 2018, "yellow", true);

        return new PersonalCar[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
