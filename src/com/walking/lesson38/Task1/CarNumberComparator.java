package com.walking.lesson38.Task1;

import java.util.Comparator;

public class CarNumberComparator implements Comparator<Car> {
    public int compare(Car a, Car b){
        return a.getNumber().compareTo(b.getNumber());
    }
}
