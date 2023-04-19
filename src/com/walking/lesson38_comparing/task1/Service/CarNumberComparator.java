package com.walking.lesson38_comparing.task1.Service;

import com.walking.lesson38_comparing.task1.model.Car;

import java.util.Comparator;

public class CarNumberComparator implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		return car1.getIdentifier().getNumber().compareTo(car2.getIdentifier().getNumber());
	}

}
