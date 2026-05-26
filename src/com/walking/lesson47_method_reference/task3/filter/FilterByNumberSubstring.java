package com.walking.lesson47_method_reference.task3.filter;

import com.walking.lesson47_method_reference.task3.model.Car;

public class FilterByNumberSubstring implements Filter {
    private final String str;
    private final String regex;

    public FilterByNumberSubstring(String str) {
        this.str = str;
        regex = "^.*" + str + ".*$";
    }

    @Override
    public boolean filter(Car car) {
        return car.getIdentifier().getNumber().matches(regex);
    }
}
