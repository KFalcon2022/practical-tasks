package com.walking.lesson49_optional.task2;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentificator;
import com.walking.lesson49_optional.task2.service.CarArrayInit;
import com.walking.lesson49_optional.task2.service.CarCheckService;
import com.walking.lesson49_optional.task2.service.CarSearchService;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализуйте рад классов:
 * 1. Жилье, должен иметь поле «адрес»;
 * 2. Человек. Поля – «имя», «мать», «отец», «дети», «жилье», «машина», «профессия»;
 * 3. Машина. Предлагаю взять реализацию из Задачи 1 и добавить к ней поле «владелец» типа «Человек». (+ год выпуска)
 * Реализуйте поиск адреса проживания первого ребенка владельца машины с заданным номером и годом выпуска.
 * Используйте реализацию поиска машины из Задачи 1. Изменять ее под требования текущей задачи – недопустимо.
 * <p>
 * Поиск должен быть прекращен, если совпало хотя бы одно из условий:
 * · машина новее 2021 года;
 * · профессия владельца машины или его первого ребенка – «полицейский»;
 * · адрес проживания содержит подстроку «Рублевское шоссе».
 * <p>
 * В таких случаях ничего не должно быть найдено.
 */
public class Main {
    public static void main(String[] args) {
        Car[] carsArray = CarArrayInit.createCarArray();
        Map<Integer, Car> cars = CarArrayInit.createCarMap(carsArray);

        CarIdentificator carIdentificator = CarSearchService.createCarIdToSearch();

        CarCheckService searchResult = new CarCheckService(CarSearchService.findCar(cars, carIdentificator));
        searchResult.getSearchResult();

    }
}
