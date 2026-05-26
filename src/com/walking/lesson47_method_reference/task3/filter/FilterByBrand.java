package com.walking.lesson47_method_reference.task3.filter;

import com.walking.lesson47_method_reference.task3.model.Car;

public class FilterByBrand implements Filter {
    private final String brand;

    public FilterByBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean filter(Car car) {
        return car.getIdentifier().getBrand().equals(brand);
    }
}
