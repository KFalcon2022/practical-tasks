package com.walking.lesson43_map.task2;


import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.model.ColorType;
import com.walking.lesson43_map.task2.model.MarkType;
import com.walking.lesson43_map.task2.service.SearchCarService;

import java.util.HashMap;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods">...</a>,
 * используя Map.
 * Реализацию выберите исходя из особенностей исходной задачи.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Car> cars = initCars();
        SearchCarService carService = new SearchCarService(cars);

        Car searchCar = carService.search(674925);

        System.out.println(searchCar);
    }

    private static HashMap<Integer, Car> initCars() {
        HashMap<Integer, Car> result = new HashMap<>();
        result.put(674921, new Car(MarkType.AUDI, ColorType.BLACK, 2001, 674921));
        result.put(674922, new Car(MarkType.BMW, ColorType.BLUE, 2002, 674922));
        result.put(674923, new Car(MarkType.RENAULT, ColorType.GREEN, 2003, 674923));
        result.put(674924, new Car(MarkType.LADA, ColorType.RED, 2004, 674924));
        result.put(674925, new Car(MarkType.VOLVO, ColorType.GREY, 2005, 674925));
        result.put(674926, new Car(MarkType.KIA, ColorType.WHITE, 2006, 674926));
        result.put(674927, new Car(MarkType.MAZDA, ColorType.YELOW, 2007, 674927));
        result.put(674928, new Car(MarkType.SUZUKI, ColorType.RED, 2008, 674928));
        result.put(674929, new Car(MarkType.LADA, ColorType.BLUE, 2009, 674929));

        return result;
    }
}
