package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.Car;
import com.walking.lesson49_optional.task2.model.Housing;
import com.walking.lesson49_optional.task2.model.Human;

import java.util.List;
import java.util.Optional;

public class HousingSearchService {
    private final CarService service;

    public HousingSearchService(CarService service) {
        this.service = service;
    }

    public Optional<Housing> get(Car car) {
        return Optional.ofNullable(car)
                .filter(c -> c.getIdentifier().getReleaseYear() <= 2021)
                .map(Car::getOwner)
                .filter(o -> !o.getProfession().equals("полицейский"))
                .map(Human::getKids)
                .map(List::getFirst)
                .filter(o -> !o.getProfession().equals("полицейский"))
                .map(Human::getHousing)
                .filter(h -> !h.getAddress().matches("^.*Рублёвское шоссе.*$"));
    }

    public CarService getService() {
        return service;
    }
}
