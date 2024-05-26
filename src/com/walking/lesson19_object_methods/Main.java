package com.walking.lesson19_object_methods;

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
        CarService carService = new CarService(initCars());

        Car desiredCar = createCar();
        Car foundCar = carService.findCar(desiredCar);

        System.out.println(foundCar);


    }

    private static Car createCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер автомобиля: ");
        String requestNumber = scanner.nextLine();
        System.out.println("Введите марку автомобиля: ");
        String requestCarMake = scanner.nextLine();
        System.out.println("Введите модель автомобиля: ");
        String requestModel = scanner.nextLine();
        System.out.println("Введите год автомобиля: ");
        int requestYear = scanner.nextInt();
        scanner.close();
        return new Car(requestCarMake, requestModel, requestNumber, requestYear);
    }

    private static Car[] initCars() {
        Car car1 = new Car("BMW", "E90", "1234", 2007);
        Car car2 = new Car("Toyota", "Corolla", "1234", 1998);
        Car car3 = new Car("Toyota", "Camry", "0890", 2011);

        return new Car[]{car1, car2, car3};
    }
}

