package com.walking.lesson43_map.task2;


import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.model.ColorList;
import com.walking.lesson43_map.task2.model.MarkList;
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
        SearchCarService carService = new SearchCarService();

        HashMap<Integer, Car> cars = initCars();

        Car searchCar = carService.searchCar(674921, cars);

        System.out.println(searchCar);
    }

    private static HashMap<Integer, Car> initCars() {
        HashMap<Integer, Car> result = new HashMap<>();
        result.put(674921, new Car(MarkList.AUDI, ColorList.BLACK, 2001, 674921));
        result.put(674922, new Car(MarkList.BMW, ColorList.BLUE, 2002, 674922));
        result.put(674923, new Car(MarkList.RENAULT, ColorList.GREEN, 2003, 674923));
        result.put(674924, new Car(MarkList.LADA, ColorList.RED, 2004, 674924));
        result.put(674925, new Car(MarkList.VOLVO, ColorList.GREY, 2005, 674925));
        result.put(674926, new Car(MarkList.KIA, ColorList.WHITE, 2006, 674926));
        result.put(674927, new Car(MarkList.MAZDA, ColorList.YELOW, 2007, 674927));
        result.put(674928, new Car(MarkList.SUZUKI, ColorList.RED, 2008, 674928));
        result.put(674929, new Car(MarkList.LADA, ColorList.BLUE, 2009, 674929));

        return result;
    }
}
