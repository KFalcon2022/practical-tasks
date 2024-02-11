package com.walking.lesson61_synchronized.service;

import com.walking.lesson61_synchronized.model.Car;
import com.walking.lesson61_synchronized.model.CarIdentificator;

public class CarGeneratorService {
    public CarGeneratorService() {
    }

    public Car[] createCarArray() {
        Car car1 = new Car(new CarIdentificator("RR-111-RR", 2015), "yellow");
        Car car2 = new Car(new CarIdentificator("RR-222-RR", 2022), "yellow");
        Car car3 = new Car(new CarIdentificator("RR-333-RR", 2017), "green");
        Car car4 = new Car(new CarIdentificator("RR-444-RR", 2018), "red");
        Car car5 = new Car(new CarIdentificator("RR-555-RR", 2018), "yellow");
        Car car6 = new Car(new CarIdentificator("RR-666-RR", 2018), "black");
        Car car7 = new Car(new CarIdentificator("RR-777-RR", 2018), "black");
        Car car8 = new Car(new CarIdentificator("RR-888-RR", 2018), "yellow");
        Car car9 = new Car(new CarIdentificator("RR-999-RR", 2018), "white");
        Car car10 = new Car(new CarIdentificator("RR-000-RR", 2018), "yellow");

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
