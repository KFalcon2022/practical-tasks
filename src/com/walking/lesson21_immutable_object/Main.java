package com.walking.lesson21_immutable_object;


import com.walking.lesson21_immutable_object.model.Car;
import com.walking.lesson21_immutable_object.model.CarIndetifier;

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
        Car[] cars = new Car[10];
        fillCarArray(cars);
        searchCarInDataBase("2B3LA53H08H256544", cars);
    }

    private static void fillCarArray(Car[] cars) {
        cars[0] = new Car("blue", "BMW", "8888KA-3",new CarIndetifier("2B3LA53H08H256544"));
        cars[1] = new Car("purple", "Nissan", "8888KA-2", new CarIndetifier("2GCEC19K9K1134990"));
        cars[2] = new Car("white", "Skoda", "1853KE-1", new CarIndetifier("2G1WH52K959272082"));
        cars[3] = new Car("blue", "Lada", "8318GA-7", new CarIndetifier("WBAEU33404PR42781"));
        cars[4] = new Car("white", "BMW", "8888KA-7", new CarIndetifier("5NPDH4AE5DH344346"));
        cars[5] = new Car("black", "Dodge", "9718GD-7", new CarIndetifier("1G2ZG57B084162811"));
        cars[6] = new Car("yellow", "Opel", "1288DS-4", new CarIndetifier("1FADP3F20DL202208"));
        cars[7] = new Car("black", "Renault", "9238JH-5", new CarIndetifier("1N4AL21E78N545909"));
        cars[8] = new Car("silver", "BMW", "5546KJ-7", new CarIndetifier("2A4RR8DG2BR707087"));
        cars[9] = new Car("black", "Nissan", "8127SA-7", new CarIndetifier("1FAFP55SXYA259149"));
    }

    private static void searchCarInDataBase(String VIN, Car[] cars) {
        for (Car car : cars) {
            if (car.equalsCar(VIN)) {
                System.out.println("Машина c VIN номером " + car.getCarIndetifier().getVIN_number() + " найдена в базе!");
                return;
            }
        }
        System.out.println("Машины в базе нет!");
    }
}
