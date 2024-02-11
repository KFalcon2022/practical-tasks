package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentificator;
import com.walking.lesson49_optional.task2.model.Citizen;
import com.walking.lesson49_optional.task2.model.Housing;

import java.util.HashMap;

public class CarArrayInit {
    private static final String ignoredHabitation = "Рублевское шоссе, 1";
    private static final String availableHabitation = "Советская, 10";

    public static Car[] createCarArray(){
        Citizen citizen1 = new Citizen();
        citizen1.setProfession("Полицейский");
        citizen1.setHouse(new Housing(availableHabitation));

    Citizen citizen2 = new Citizen();
        citizen2.setProfession("Безработный");
        citizen2.getChildren().add(citizen1);
        citizen2.setHouse(new Housing(availableHabitation));

    Citizen citizen3 = new Citizen();
        citizen3.setProfession("Строитель");
        citizen3.getChildren().add(citizen2);
        citizen3.setHouse(new Housing(ignoredHabitation));

    Citizen citizen4 = new Citizen();
        citizen4.setProfession("Учитель");
        citizen4.getChildren().add(citizen3);
        citizen4.setHouse(new Housing(availableHabitation));

    Citizen citizen5 = new Citizen();
        citizen5.setProfession("Инженер");
        citizen5.getChildren().add(citizen3);
        citizen5.setHouse(new Housing(availableHabitation));

    Car car1 = new Car(new CarIdentificator("RR-111-RR", 2015), "yellow", citizen1);
    Car car2 = new Car(new CarIdentificator("RR-222-RR", 2022), "yellow", citizen5);
    Car car3 = new Car(new CarIdentificator("RR-333-RR", 2017), "yellow", citizen3);
    Car car4 = new Car(new CarIdentificator("RR-444-RR", 2018), "yellow", citizen4);
    Car car5 = new Car(new CarIdentificator("RR-555-RR", 2018), "yellow", citizen2);
    Car car6 = new Car(new CarIdentificator("RR-666-RR", 2018), "yellow", citizen1);
    Car car7 = new Car(new CarIdentificator("RR-777-RR", 2018), "yellow", citizen1);
    Car car8 = new Car(new CarIdentificator("RR-888-RR", 2018), "yellow", citizen1);
    Car car9 = new Car(new CarIdentificator("RR-999-RR", 2018), "yellow", citizen1);
    Car car10 = new Car(new CarIdentificator("RR-000-RR", 2018), "yellow", citizen1);


        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
    public static HashMap<Integer,Car> createCarMap(Car[] cars){
        HashMap<Integer,Car> resultMap = new HashMap<>();
        for (Car car:cars){
            resultMap.put(car.getCarIdentificator().hashCode(),car);
        }
        return resultMap;
    }
}
