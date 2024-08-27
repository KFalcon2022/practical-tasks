package com.walking.lesson46_lambda.task3.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

import com.walking.lesson46_lambda.task3.model.Car;

public class CarService {
    private LinkedList<Car> cars;

    public CarService(LinkedList<Car> cars){
        this.cars=cars;
    }

    public Collection<Car> findCars(Predicate<Car> filter){
        LinkedList<Car> result=new LinkedList<>();
        for (Car car : cars) {
            if (filter.test(car)) result.add(car);
        }
        return (Collection<Car>)result;
    }
}
