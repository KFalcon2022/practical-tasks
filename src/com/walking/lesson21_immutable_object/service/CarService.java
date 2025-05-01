package com.walking.lesson21_immutable_object.service;

import com.walking.lesson21_immutable_object.CarFindException;
import com.walking.lesson21_immutable_object.model.PersonalCar;

public class CarService {
    PersonalCar[] cars;

    public CarService(PersonalCar[] cars) {
        this.cars = cars;
    }

    public PersonalCar findCar(PersonalCar car) throws CarFindException {

        for (PersonalCar c : cars) {
            if (c.hashCode() == car.hashCode() && c.equals(car)) {
                return c;
            }
        }
        throw new CarFindException("Car not found");
    }
}