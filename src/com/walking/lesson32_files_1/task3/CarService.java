package com.walking.lesson32_files_1.task3;

import java.util.Arrays;

public class CarService {
    private Car[] cars;

    public Car[] getCars() {
        return cars;
    }

    public CarService(Car[] cars) {
        this.cars = cars;
    }

    public Car addCar(Car car) {
        Car existedCar = findCar(car);

        if (existedCar != null) {
            System.out.println("Car already exist!");
            return existedCar;
        }

        cars = Arrays.copyOf(cars, cars.length + 1);
        cars[cars.length - 1] = car;

        return car;
    }

    public Car updateCar(Car car) {
        Car existedCar = findCar(car);

        if (existedCar == null) {
            System.out.println("Can't update non-existing car!");
            return car;
        }

        existedCar.setCarNumber(car.getCarNumber());

        return existedCar;
    }

    public void remove(Car car) {
        Integer index = findCarIndex(car);

        if (index == null) {
            System.out.println("Car is not exist!");
            return;
        }

        if (index == cars.length - 1) {
            cars = Arrays.copyOf(cars, cars.length - 1);
            return;
        }

        Car[] newCars = new Car[cars.length - 1];

        int i = 0;
        int j = 0;

        while (i < newCars.length) {
            if (j == index) {
                j++;
            }

            newCars[i] = cars[j];
            i++;
            j++;
        }

        cars = newCars;
    }

    private Car findCar(Car c) {
        for (Car car : cars) {
            if (c.hashCode() == car.hashCode() && c.equals(car)) {
                return car;
            }
        }
        return null;
    }

    private Integer findCarIndex(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].hashCode() == car.hashCode() && cars[i].equals(car)) {
                return i;
            }
        }
        return null;
    }

}
