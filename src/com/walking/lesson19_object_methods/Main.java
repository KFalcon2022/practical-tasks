package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;

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
        Car[] cars = new Car[]{
            new Car("Toyota", "Mark 2", "1999", "Beautiful White", "O712BP125","GX105-6006383"),
            new Car("Honda", "Fit", "2014", "White", "P590HT125", "DAA-GP66545234"),
            new Car("Toyota", "Vitz", "2008", "Grey", "H523HC125","NCP11-231532123"),
            new Car("Nissan", "Note", "2011", "Blue", "H925TC125","gvno103952736"),
            new Car("Toyota", "Probox", "2005", "White", "B150EM125","pizda123587543"),
            new Car("Toyota", "Crown", "2020", "Black", "X777XX777","S220N11-9043234"),
        };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car Vendor: ");
        String vendor = sc.nextLine().toLowerCase().replace(" ", "_");
        System.out.print("Enter car Model: ");
        String model = sc.nextLine().toLowerCase().replace(" ", "_");
        System.out.print("Enter government registration number: ");
        String regNum = sc.nextLine().toLowerCase().replace(" ", "");
        int hashCode = (vendor + model + regNum).hashCode() * 31;

        System.out.println(findCar(cars, hashCode));



        }

        public static String findCar(Car[] cars, int hashCode){
            String result = "Car not found in base!";
            for (int i = 0; i < cars.length; i++) {
                if (cars[i].hashCode() == hashCode) {
                    result = "\nCar is found!" + "\n" +
                            "Vendor: " + (cars[i].getVendor()) + "\n" +
                            "Model: " + cars[i].getModel() + "\n" +
                            "Issue year: " + cars[i].getIssueYear() + "\n" +
                            "Frame/Body number or VIN: " + cars[i].getVin().toUpperCase() + "\n" +
                            "Color: " + cars[i].getColor() + "\n" +
                            "Registration number: " + cars[i].getRegNumber().toUpperCase() + "\n";
                    return result;
                }
            }
            return result;
    }
}
