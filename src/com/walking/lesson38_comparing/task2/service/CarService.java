package com.walking.lesson38_comparing.task2.service;

import com.walking.lesson38_comparing.task2.model.Car;

import java.util.ArrayList;
import java.util.Collections;

public class CarService {
    private ArrayList<Car> carList;

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public CarService(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void sort() {
        Collections.sort(carList);
    }

    public void sortInReverseOrder() {
        Collections.sort(carList, Collections.reverseOrder());
    }
}
