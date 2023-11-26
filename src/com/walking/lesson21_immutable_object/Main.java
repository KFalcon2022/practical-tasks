package com.walking.lesson21_immutable_object;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
import com.walking.lesson21_immutable_object.exceptions.CarNotFoundException;
import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.CarFeatures;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car[] cars = {
                new Car(new CarFeatures("ZFA25648900556937", "Ferrari", "petrol"), "person1"),
                new Car(new CarFeatures("ZFA22356404865217", "Bugatti", "electric"), "person2"),
                new Car(new CarFeatures("ZFA44523895557832", "Land Rover", "petrol"), "person3"),
                new Car(new CarFeatures("ZFA21235685446546", "Cadillac", "petrol"), "person4")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите vin");
        String VIN = scanner.next();
        System.out.println("Введите brand");
        String brand = scanner.next();
        System.out.println("Введите engineType");
        String engineType = scanner.next();
        try {
            findCar(cars, new Car(new CarFeatures(VIN, brand, engineType)));
        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Car findCar(Car[] cars, Car needToFind) throws CarNotFoundException {
        for (Car car : cars) {
            if (car.equals(needToFind)) {
                return car;
            }
        }
        throw new CarNotFoundException("Couldn't find  " + needToFind);
    }
}
