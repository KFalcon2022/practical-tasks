package com.walking.lesson71_thread_safe_collections.task1.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.walking.lesson71_thread_safe_collections.task1.model.Car;



public class CarService {
    private CopyOnWriteArrayList<Car> cars;

    public CarService(){
        this.cars=new CopyOnWriteArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public List<Car> getCars(Predicate<? super Car> filter){
        return cars.stream().filter(filter).collect(Collectors.toList());
    }

    public int getCar(Car car){
        return cars.indexOf(car);

    }

    public Car delCar(int id){
        return cars.remove(id);
    }

    public Car changeCar(int id, Car car){
        return cars.set(id, car);
    }

    
}
