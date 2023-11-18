package com.walking.lesson21_immutable_object;

/**
 * Реализуйте задачу из урока 19.
 * <p>
 * На свое усмотрение, вынесите неизменяемые поля,
 * используемые для идентификации и поиска машины в отдельный immutable класс
 * или сделайте весь класс «Машина» неизменяемым.
 * Правильный выбор зависит от набора полей, который существует в вашей текущей реализации класса «Машина».
 */
import com.walking.lesson21_immutable_object.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car cars[] = new Car[]{
                new Car("123av", "a"),
                new Car("456ay", "b"),
                new Car("123av", "c")};

        System.out.print("car number:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        System.out.print("car model:");
        String model = scanner.next();

        Car desiredCar = new Car(number, model);

        Car searchedCar = searchCar(cars, desiredCar);

        if (searchedCar!=null){
            System.out.println(searchedCar.toString());
        } else System.out.println("Car not found");

    }

    private static Car searchCar(Car[] cars, Car desiredCar) {

        for (Car car:cars){
            if (car.equals(desiredCar)){
                return car;
            }
        }

        return null;

    }
}

