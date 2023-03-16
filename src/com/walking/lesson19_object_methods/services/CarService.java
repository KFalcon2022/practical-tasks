package com.walking.lesson19_object_methods.services;

import com.walking.lesson19_object_methods.model.Car;

public class CarService {
    Car[] cars;



    public CarService(){
        this.cars = new Car[]{new Car("a123aa","red","ford")
                ,new Car("b234bb","yellow","bmw")
                ,new Car("a123aa","blue","audi")
                ,new Car("n555nn","black", "lada")
        };
    }

    public CarService(Car ...cars){
        this.cars = new Car[cars.length];
        System.arraycopy(cars, 0, this.cars, 0, cars.length);
    }

    public boolean checkCar(String govNumber, String mark, String color){
        for (Car c: cars) {
            if (c.getGovNumber().equals(govNumber) && c.getMark().equals(mark) && c.getColor().equals(color)){
                return true;
            }
        }
        return false;

    }

    public boolean checkCar(Car car){
        for (Car c: cars) {
            if (c.equals(car)){
                return true;
            }
        }
        return false;
    }
}
