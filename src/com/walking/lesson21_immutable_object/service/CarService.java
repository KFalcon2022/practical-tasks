package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.model.Car;

public class CarService {
    private Car[] cars;

    public CarService(Car[] cars){
        this.cars=cars;
    }

    public Car findCar(Car car){
        for(Car x:this.cars){
            if (x.hashCode()==car.hashCode()&&x.equals(car)){
                return x;
            }
        }
        return null;
    }
}
