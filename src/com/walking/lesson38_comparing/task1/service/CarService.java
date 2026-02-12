package com.walking.lesson38_comparing.task1.service;

import com.walking.lesson38_comparing.task1.model.Car;
import com.walking.lesson38_comparing.task1.model.CarIdentifier;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public List<Car> getCars() {
        return cars;
    }

    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    //    Упростим реализацию метода в сравнении с вариантом в уроке 19 для большей наглядности
    public Car findCar(CarIdentifier identifier) {
        for (Car c : cars) {
//            Нет особого смысла реализовывать и использовать equals() для Car, по крайне мере,
//            для операции поиска
            if (c.getIdentifier().equals(identifier)) {
                return c;
            }
        }

//        По желанию можно выбросить исключение
        return null;
    }
}
