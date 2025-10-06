package com.walking.lesson21_immutable_object;


import com.walking.lesson21_immutable_object.cars.Car;
import com.walking.lesson21_immutable_object.cars.CarImmutable;

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
        Car[] cars = {new Car("toyota", "VIN123r431234", 1999, "AWD", "AT", 1.6, "A654EE154"),
            new Car("nissan", "VINw-vdojqw3qv", 2006, "4WD", "MT", 1.8, "T655TT196"),
            new Car("haval", "VIN3ef2efwvawa", 2020, "4WD", "CVT", 2.6, "E111EE777")};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter brand car");
        String brand = scanner.next();

        System.out.println("Enter year car");
        int year = scanner.nextInt();

        System.out.println("Enter car drive");
        String carDrive = scanner.next();

        System.out.println("Enter transmission car");
        String transmission = scanner.next();

        System.out.println("Enter engine capacity car");
        double engineCapacity = Double.parseDouble(scanner.next());


        scanner.close();

        CarImmutable carIn = new CarImmutable(brand, year, carDrive, transmission, engineCapacity);

        Car resultCar = searchCar(carIn, cars);

        System.out.println(resultCar);
    }

    public static Car searchCar(CarImmutable carImmutable, Car[] cars) {
        for (Car car: cars) {
            if(carImmutable.hashCode() == car.getCarImmutable().hashCode() && carImmutable.equals(car.getCarImmutable())) {
                return car;
            }
        }
        return  null;
    }

    public static Car[] createArrayCar () {
        return new Car[]{
                new Car("toyota", "VIN123r431234", 1999, "AWD", "AT", 1.6, "A654EE154"),
                new Car("nissan", "VINw-vdojqw3qv", 2006, "4WD", "MT", 1.8, "T655TT196"),
                new Car("haval", "VIN3ef2efwvawa", 2020, "4WD", "CVT", 2.6, "E111EE777")
        };
    }
}
