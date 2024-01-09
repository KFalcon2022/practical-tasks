package com.walking.lesson49_optional.task1;

import com.walking.lesson19_object_methods.model.Car;
import com.walking.lesson49_optional.task1.service.CarFillService;
import com.walking.lesson49_optional.task1.service.CarSearchService;

import java.util.*;

/**
 * Реализуйте задачу 2 урока 43:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson43_map/task2">...</a>
 * тип возвращаемого значения в методе поиска должен быть Optional<Car>.
 * Если ничего не найдено – верните Optional.empty().
 */
public class Main {
    public static void main(String[] args) {

        CarSearchService.findCar((CarFillService.getCarMap()));
    }
}
