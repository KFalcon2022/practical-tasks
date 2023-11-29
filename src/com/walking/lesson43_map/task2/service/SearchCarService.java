package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.model.Car;

import java.util.HashMap;
import java.util.Map;

public class SearchCarService {

    public Car searchCar(Integer number, HashMap<Integer, Car> cars) {

        for (Map.Entry<Integer, Car> car : cars.entrySet()) {

            if (number.equals(car.getKey())) {

                return car.getValue();
            }
        }

        return null;
    }
}
