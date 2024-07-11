package com.walking.lesson32_files_1.task3.service;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task3.model.CarRepository;

public class CarService {
    private Car[] cars;
    private final String PATH="./resource/Cars.txt";

    public CarService(){
        cars=CarRepository.loadCars(PATH);
    }

    public Car[] getCars() {
        return cars;
    }

    public Car[] editCar(int index, Car car){
        cars[index]=car;
        CarRepository.saveCars(cars, PATH);
        return cars;
    }

    public Car[] addCar(Car car){
        Car[] temp=new Car[cars.length+1];
        for (int i = 0; i < temp.length-1; i++) {
            temp[i]=cars[i];
        }
        temp[temp.length-1]=car;
        cars=temp;
        CarRepository.saveCars(cars, PATH);
        return cars;
    }

    public Car[] delCar(int index){
        Car[] temp=new Car[cars.length-1];
        cars[index]=null;
        int i=0;
        for (Car car : cars) {
            if (car!=null){
                temp[i]=car;
                i++;
            }
        }
        cars=temp;
        CarRepository.saveCars(cars, PATH);
        return cars;
    }
}
