package com.walking.lesson37_collection_list.task2.service;
import com.walking.lesson37_collection_list.task2.exceptions.ElementNotFoundException;
import com.walking.lesson37_collection_list.task2.model.Car;

import java.util.List;

public class ServiceCarCatalog {
	final private List<Car> cars;

	public ServiceCarCatalog(List<Car> cars) {
		this.cars = cars;
	}

	public void printList() {
		for (Car car : cars) {
			System.out.println(car + "\n");
		}
	}

	public Car returnCarByIndex(int index){
		return cars.get(index);
	}

	public Car searchCarByRegNumber(String regNum) throws ElementNotFoundException {
		for (Car car : cars) {
			if (car.getRegNumber().equals(regNum)) {
				return car;
			}
		}throw new ElementNotFoundException();
	}

	public Car removeCar(String regNum){
		return cars.remove(searchCar(regNum));
	}

	public int addCar(Car car){
		cars.add(car);
		return cars.size() - 1;
	}

	private int searchCar(String regNum){
		for (Car car : cars) {
			if (car.getRegNumber().equals(regNum)) {
				return cars.indexOf(car);
			}
		}throw new ElementNotFoundException();
	}
}
