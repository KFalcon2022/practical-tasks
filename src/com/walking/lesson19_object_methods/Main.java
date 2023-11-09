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
        Car[] cars = new Car[]{new Car("Р079ВК92", "Toyota", "Camry", 2017, "1234567891234567"),
                new Car("А567ЕУ45", "BMW", "X5", 2019, "9876543219876543"),
                new Car("М891OР77", "Ford", "Focus", 2020, "4567891234567891"),
                new Car("Е456ВО63", "Mercedes-Benz", "E-Class", 2018, "7891234567891234"),
                new Car("К789МН51", "Honda", "Civic", 2016, "6543219876543219")};

        Car anotherCar = new Car("У654НО77","Volkswagen","Golf",2015,"3219876543219876");
        Car samCar = new Car("К789МН51", "Honda", "Civic", 2016, "6543219876543219");

        System.out.println("==============================");
        System.out.println(findCar(samCar,cars));

        System.out.println("==============================");
        System.out.println(findCar(anotherCar,cars));
        System.out.println("==============================");

        Scanner in = new Scanner(System.in);

        System.out.println("Введите регистрационный номер");
        String regNumb = in.nextLine();

        System.out.println("Введите марку автомобиля");
        String brand = in.nextLine();

        System.out.println("Введите модель автомобиля");
        String model = in.nextLine();

        System.out.println("Введите год выпуска автомобиля");
        int yearCar = in.nextInt();

        System.out.println("Введите VIN автомобиля");
        String vin = in.nextLine();

        in.close();

        Car car = new Car(regNumb,brand,model,yearCar,vin);

        System.out.println("==============================");
        findCar(car,cars);
    }

    public static String findCar(Car findCar,Car [] cars){
        for (Car car:cars){
            if(car.hashCode() == findCar.hashCode()){
                if(findCar.equals(car)){
                    return findCar.toString();
                }
            }
        }
        return null;
    }
}
