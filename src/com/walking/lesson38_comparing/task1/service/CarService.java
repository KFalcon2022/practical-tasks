package com.walking.lesson38_comparing.task1.service;

import com.walking.lesson38_comparing.task1.comparator.ColorComparator;
import com.walking.lesson38_comparing.task1.comparator.NumberComparator;
import com.walking.lesson38_comparing.task1.comparator.YearComparator;
import com.walking.lesson38_comparing.task1.model.Car;
import com.walking.lesson38_comparing.task1.model.CarIdentifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarService {
    private ArrayList<Car> carList;

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public CarService(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public Car findCar(CarIdentifier identifier) {
        for (Car c : carList) {
            if (c.getIdentifier().equals(identifier)) {
                return c;
            }
        }

        return null;
    }

    public ArrayList<Car> sortByNumber() {
        Comparator numberComparator = new NumberComparator();
        Collections.sort(carList, numberComparator);

        return carList;
    }

    public ArrayList<Car> sortByColor() {
        Comparator colorComparator = new ColorComparator();
        Collections.sort(carList, colorComparator);

        return carList;
    }

    public ArrayList<Car> sortByYear() {
        Comparator yearComparator = new YearComparator();
        carList.sort(yearComparator);

        return carList;
    }

    public ArrayList<Car> sortByNumberYear() {
        Comparator numberYearComparator = new NumberComparator().thenComparing(new YearComparator());
        Collections.sort(carList, numberYearComparator);

        return carList;
    }
}
