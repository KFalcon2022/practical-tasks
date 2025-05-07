package com.walking.lesson43_map.task2.service;

import com.walking.lesson43_map.task2.model.Car;

import java.util.HashMap;
import java.util.Map;

public class SearchCarService {
    Map<Integer, Car> carMap;

    public SearchCarService(Map<Integer, Car> carMap) {
        this.carMap = carMap;
    }

    public Car search(Integer number) {

        for (Map.Entry<Integer, Car> car : carMap.entrySet()) {

            if (number.equals(car.getKey())) {

                return car.getValue();
            }
        }

        return null;
    }
}
