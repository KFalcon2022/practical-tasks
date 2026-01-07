package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.model.Car;

import java.util.List;

public class FilterService {

    public static List<Car> filterByNumber(List<Car> cars, String number) {
        return CarService.find(cars, car -> car.getIdentifier().getNumber().equals(number));
    }

    public static List<Car> filterByNumberSubstring(List<Car> cars, String substring) {
        String regex = "^.*" + substring + ".*$";
        return CarService.find(cars, car -> car.getIdentifier().getNumber().matches(regex));
    }

    public static List<Car> filterByColor(List<Car> cars, String color) {
        return CarService.find(cars, car -> car.getColor().equals(color));
    }

    public static List<Car> filterByOwner(List<Car> cars, String owner) {
        return CarService.find(cars, car -> car.getOwner().equals(owner));
    }

    public static List<Car> filterByBrand(List<Car> cars, String brand) {
        return CarService.find(cars, car -> car.getIdentifier().getBrand().equals(brand));
    }

    public static List<Car> filterByYear(List<Car> cars, int start, int end) {
        return CarService.find(cars, car -> car.getReleaseYear() >= start && car.getReleaseYear() <= end);
    }
}
