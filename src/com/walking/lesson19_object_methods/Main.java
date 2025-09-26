package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.cars.Car;

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
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = {new Car("toyota", "VIN123r431234", 1999, "AWD", "AT", 1.6, "A654EE154"),
                new Car("nissan", "VINw-vdojqw3qv", 2006, "4WD", "MT", 1.8, "T655TT196"),
                new Car("haval", "VIN3ef2efwvawa", 2020, "4WD", "CVT", 2.6, "E111EE777")};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter brand car");
        String brand = scanner.next();

        System.out.println("Enter VIN-number car");
        String vin = scanner.next();

        System.out.println("Enter year car");
        int year = scanner.nextInt();

        System.out.println("Enter car drive");
        String carDrive = scanner.next();

        System.out.println("Enter transmission car");
        String transmission = scanner.next();

        System.out.println("Enter engine capacity car");
        double engineCapacity = Double.parseDouble(scanner.next());

        System.out.println("Enter number car");
        String number = scanner.next();

        scanner.close();

        Car carIn = new Car(brand, vin, year, carDrive, transmission, engineCapacity, number);

        Car resultCar = searchCar(carIn, cars);

        System.out.println(resultCar);
    }

    public static Car searchCar(Car carIn, Car[] cars) {
        for (Car car: cars) {
            if(carIn.hashCode() == car.hashCode() && carIn.equals(car)) {
                return car;
            }
        }
        return  null;
    }
}
