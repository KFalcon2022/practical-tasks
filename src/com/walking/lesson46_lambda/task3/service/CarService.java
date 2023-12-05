package com.walking.lesson46_lambda.task3.service;

import com.walking.lesson46_lambda.task3.model.Car;
import com.walking.lesson46_lambda.task3.model.IdentityCar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService {
    List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> search(int verificationOption) {
        List<Car> result = new ArrayList<>();


        return result;
    }

    /*
    public Car searchCar(IdentityCar searchingCar) {

        for (Car car : cars) {
            if (car.getIdentityCar().equals(searchingCar)) {
                return car;
            }
        }
        return null;
    }

     */
}
