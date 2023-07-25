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
        Car[] cars = new Car[]{
                new Car("MAZDA", "CX5", "RED", "X555CX95"),
                new Car("VOLVO", "CX70", "BLACK", "T222TT77"),
                new Car("NISSAN", "X-TRAIL", "GREY", "P420AK29"),
                new Car("CHEVROLET", "NIVA", "GREY", "H123AA51")};

        CarService carService = new CarService();
        Scanner scanner = new Scanner(System.in);

        Car foundCar = carService.foundCarInput(scanner);
        scanner.close();

        carService.findCar(foundCar, cars);
    }
}
