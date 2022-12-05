package com.walking.lesson21_mutable_immutable.task1;

import com.walking.lesson21_mutable_immutable.task1.model.Brand;
import com.walking.lesson21_mutable_immutable.task1.model.Car;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Car[] cars = new Car[4];
        cars[0] = new Car("Purple", 250, Brand.TOYOTA);
        cars[1] = new Car("Green", 50, Brand.VAZ);
        cars[2] = new Car("Red", 120);
        cars[3] = new Car("Red", 120, Brand.VAZ);


        Scanner in = new Scanner(System.in);

        System.out.print("Введите цвет интересующей вас машины:");
        String color = in.nextLine();
        System.out.print("Введите интересующую максимаьную скорость:");
        int maxSpeed = in.nextInt();

        boolean result = false;

        Car desiredCar = new Car(color, maxSpeed);



        for (Car car : cars) {
            if (car.equals(desiredCar)) { //Сравнение оп переопределенному методу сравнения equal
                System.out.println("Вам подойдет эта машина: "+car.BRAND + " цвет " + car.color + " макс. скорость " + car.getMaxSpeed());
                result = true;
            }
        }
        System.out.println("-----------------------");

        for (Car car : cars) {
            if (car.hashCode()==desiredCar.hashCode()) { //Сравнение оп переопределенному методу сравнения hashCode
                System.out.println("Вам подойдет эта машина: "+car.BRAND + " цвет " + car.color + " макс. скорость " + car.getMaxSpeed());
                result = true;
            }
        }


        if (!result) {
            System.out.println("К сожалению у вас завышеные требования.\nА вот что есть в наличии:");
            for (Car car : cars) {
                if (car != null) {
                    System.out.println(car.BRAND + " цвет " + car.color + " макс. скорость " + car.getMaxSpeed());
                }
            }
        }


    }
}