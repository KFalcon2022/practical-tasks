package com.walking.lesson38.Task1;

import java.util.Comparator;

public class CarOwnerComparator implements Comparator<Car> {
    public int compare(Car a, Car b){
        return a.getOwner().compareTo(b.getOwner());
    }
}
