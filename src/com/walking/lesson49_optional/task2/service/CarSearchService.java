package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.CarIdentificator;

import java.util.Map;
import java.util.Optional;

// В условии сказано, что изменять алгоритм поиска недопустимо,
// но в моей CarSpecification не был предусмотрен номер машины
// (соотв. в поиске тоже), поэтому доработка необходима
public class CarSearchService {
    public static CarIdentificator createCarIdToSearch(){
        final String PLATE_NUMBER = InputService.getPlateNumber();
        final int RELEASE_YEAR = InputService.getYear();
        InputService.close();
        return new CarIdentificator(PLATE_NUMBER,RELEASE_YEAR);
    }
    public static Optional<Car> findCar (Map<Integer,Car> cars, CarIdentificator carID){
        return Optional.ofNullable(cars.get(carID.hashCode()));
    }
}
