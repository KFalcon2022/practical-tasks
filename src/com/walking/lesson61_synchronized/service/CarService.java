package com.walking.lesson61_synchronized.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.walking.lesson61_synchronized.model.Car;

public class CarService {
    private ArrayList<Car> cars;

    public CarService(){
        this.cars=new ArrayList<>();
    }

    public void addCar(Car car){
        synchronized (cars){
            cars.add(car);
        }
    }

    public List<Car> getCars(Predicate<? super Car> filter){
        synchronized (cars){
            return cars.stream().filter(filter).collect(Collectors.toList());
        }
    }

    public int getCar(Car car){
        synchronized(cars){
            return cars.indexOf(car);
        }
    }

    public Car delCar(int id){
        synchronized(cars){
            return cars.remove(id);
        }
    }

    public Car changeCar(int id, Car car){
        synchronized(cars){
            return cars.set(id, car);
        }
    }

    
}
