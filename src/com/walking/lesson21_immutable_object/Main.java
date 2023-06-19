package com.walking.lesson21_immutable_object;

import com.walking.lesson21_immutable_object.model.Car;

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
        Car[] cars = new Car[]{new Car("Р079ВК92","Red" ,"Toyota", "Camry", 2017, "1234567891234567"),
                new Car("А567ЕУ45","Red", "BMW", "X5", 2019, "9876543219876543"),
                new Car("М891OР77","Red", "Ford", "Focus", 2020, "4567891234567891"),
                new Car("Е456ВО63","Red", "Mercedes-Benz", "E-Class", 2018, "7891234567891234"),
                new Car("К789МН51","Red", "Honda", "Civic", 2016, "6543219876543219")};

        Car anotherCar = new Car("У654НО77","Red","Volkswagen","Golf",2015,"3219876543219876");
        Car samCar = new Car("К789МН51","Red", "Honda", "Civic", 2016, "6543219876543219");

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

        System.out.println("Введите цвет корпуса автомобиля");
        String color = in.nextLine();

        System.out.println("Введите модель автомобиля");
        String model = in.nextLine();

        System.out.println("Введите год выпуска автомобиля");
        int yearCar = in.nextInt();

        System.out.println("Введите VIN автомобиля");
        String vin = in.nextLine();

        in.close();

        Car car = new Car(regNumb, color,brand,model,yearCar,vin);

        System.out.println("==============================");
        findCar(car,cars);
    }

    public static String findCar(Car findCar,Car [] cars){
        for (Car car:cars){
            if(car.getHashcode() == findCar.getHashcode()){
                if(findCar.equals(car)){
                    return findCar.toString();
                }
            }
        }
        return null;
    }
}
