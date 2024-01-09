package com.walking.lesson49_optional.task1.service;

import com.walking.lesson19_object_methods.model.Car;

import java.util.HashMap;

public class CarFillService {
    private static HashMap<Integer, Car> carsArray = new HashMap<>();
    public static HashMap<Integer, Car> getCarMap(){
        Car car1=new Car("Tesla","X",RandomService.randomVin(),"X117EN799");
        carsArray.put(car1.hashCode(),car1);
        car1=new Car("Rollce Royce","Phantom",RandomService.randomVin(),"H726KT799");
        carsArray.put(car1.hashCode(),car1);
        car1=new Car("Hyndai","Santa Fe",RandomService.randomVin(),"C111KK77");
        carsArray.put(car1.hashCode(),car1);
        car1=new Car("Tesla","X",RandomService.randomVin(),"X117EN799");
        carsArray.put(car1.hashCode(),car1);

        return carsArray;
    }
}
