package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.autos.Car;
import com.walking.lesson21_immutable_object.autos.CarIdentifier;

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

        Car[] cars = new Car[6];
        cars[0] = new Car("Audi", "Печкин Ф.Б.", "уе777к");
        cars[1] = new Car("BMW", "Борисов Ю.А.", "ос025р");
        cars[2] = new Car("Ford", "Снегирь Ю.В.", "мр666м");
        cars[3] = new Car("Bentley", "Белова Д.М.", "ра345з");
        cars[4] = new Car("Ferrari", "Сергеев К.Л.", "уе999з");
        cars[5] = new Car("Москвич", "Попов А.Д.", "ар832с");

        Scanner in = new Scanner(System.in);
        System.out.print("Марка машины: ");
        String brand = in.nextLine();
        System.out.print("Номер машины: ");
        String number = in.nextLine();

        CarIdentifier car = new CarIdentifier(brand, number);
        Car car1 = findCar(cars, car);

        if (car1 == null) {
            System.out.println("Машина не найдена!");
        } else {
            System.out.println(car1);
        }
    }

    public static Car findCar(Car[] cars, CarIdentifier car) {
        for (Car car1 : cars) {
            if (car1.getIdentifier().equals(car)) {
                return car1;
            }
        }
        return null;
    }
}