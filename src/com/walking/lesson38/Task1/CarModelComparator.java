package com.walking.lesson38.Task1;

import java.util.Comparator;

public class CarModelComparator implements Comparator<Car> {
    public int compare(Car a, Car b){
        return a.getModel().compareTo(b.getModel());
    }
}
