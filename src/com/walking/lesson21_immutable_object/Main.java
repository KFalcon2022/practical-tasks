package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.services.CarService;

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
        System.out.println("lesson21_immutable_object");

        Scanner in = new Scanner(System.in);
        System.out.println("enter govNumber:");
        String govNumber = in.nextLine();
        System.out.println("enter mark:");
        String mark = in.nextLine();

        in.close();

        CarService cs = new CarService();
        System.out.println(cs.checkCar(govNumber, mark));
        System.out.println(cs.checkCar(new Car(govNumber, "color", mark)));
    }
}
