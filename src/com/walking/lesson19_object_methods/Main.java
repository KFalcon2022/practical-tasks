package com.walking.lesson19_object_methods;

import com.walking.lesson19_object_methods.model.Car;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Car[] cars = {
				new Car("ZFA25648900556937", "Ferrari", "petrol", "person1"),
				new Car("ZFA22356404865217", "Bugatti", "electric", "person2"),
				new Car("ZFA44523895557832", "Land Rover", "petrol", "person3"),
				new Car("ZFA21235685446546", "Cadillac", "petrol", "person4")
		};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите vin");
		String VIN = scanner.next();
		System.out.println("Введите brand");
		String brand = scanner.next();
		System.out.println("Введите engineType");
		String engineType = scanner.next();
		System.out.println(findCar(cars, new Car(VIN, brand, engineType)));
		
		scanner.close();
	}
	
	private static Car findCar(Car[] cars, Car needToFind) {
		for (Car car : cars) {
			if (car.equals(needToFind)) {
				return car;
			}
		}
		return null;
	}
}
