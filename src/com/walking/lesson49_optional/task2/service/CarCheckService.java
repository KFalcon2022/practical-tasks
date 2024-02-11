package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.filter.CarYearFilter;
import com.walking.lesson49_optional.task2.filter.OwnerAdressFilter;
import com.walking.lesson49_optional.task2.filter.OwnerOrSunProfessionFilter;
import com.walking.lesson49_optional.task2.model.Car;

import java.util.Optional;

public class CarCheckService {
    private final Optional<Car> CAR_OPTIONAL;
    public CarCheckService(Optional<Car> carOptional){
        this.CAR_OPTIONAL=carOptional;
    }
    public void getSearchResult(){
        Optional.ofNullable(CAR_OPTIONAL)
                .orElseThrow()
                .filter(c-> !new CarYearFilter().test(c))
                .filter(c->!new OwnerOrSunProfessionFilter().test(c))
                .filter(c->!new OwnerAdressFilter().test(c))
                .ifPresentOrElse(
                        System.out::print,
                        ()-> System.out.println("Empty result of search."));
    }
}
