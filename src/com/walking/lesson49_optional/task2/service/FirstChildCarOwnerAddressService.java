package com.walking.lesson49_optional.task2.service;

import com.walking.lesson49_optional.task2.model.House;
import com.walking.lesson49_optional.task2.model.Human;
import com.walking.lesson49_optional.task2.model.car.Car;
import com.walking.lesson49_optional.task2.model.car.CarIdentifier;

public class FirstChildCarOwnerAddressService {
    private final CarService carService;

    public FirstChildCarOwnerAddressService(CarService carService) {
        this.carService = carService;
    }

    public String getAddress(CarIdentifier identifier) {
        return carService.findCars(identifier)
                .filter(car -> car.getIdentifier().getYear() < 2021)
                .map(Car::getOwner)
                .filter(owner -> !owner.getProfession().equals("policeman")
                        && !owner.getChild().getFirst().getProfession().equals("policeman"))
                .map(Human::getHouse)
                .filter(house -> !house.getAddress().contains("Ruble highway"))
                .map(House::getAddress)
                .orElseThrow(() -> new RuntimeException("Stop searching"));
    }
    // Пусть это останется здесь, как напоминиание мне самому о том,
    // что я тупень-вупень и могу очевидые штуки забыть нахуй)
    //
    //
    //        Optional<Car> requiredCar = carService.findCars(identifier);
//
//        Human carOwner = requiredCar.filter()
//                .map(Car::getOwner)
//                .filter(owner -> owner.)
//                .orElseThrow(() -> new RuntimeException("Search stop"));
//
//        return Optional.of(carOwner)
//                .map(Human::getHouse)
//                .map(House::getAddress)
//                .filter(this::addressFilter)
//                .orElseThrow(() -> new RuntimeException("Search stop"));
//    }

//    private boolean yearFilter(Car carOptional) {
//        return Optional.of(carOptional)
//                .map(Car::getIdentifier)
//                .map(CarIdentifier::getYear)
//                .filter(this::yearComparator)
//                .isPresent();
//    }
//
//    private boolean yearComparator(Integer carYear) {
//        return Integer.compare(carYear, 2021) > 0;
//    }
//
//    private boolean professionFilter(Optional<Human> humanOptional ) {
//        humanOptional.filter()
//    }
//
//    private boolean professionComparator(String profession) {
//        return profession
//                .toLowerCase()
//                .contains("policeman");
//    }
//
//    private boolean addressFilter(String address) {
//        return address.contains("Ruble-Highway");
//    }
}
