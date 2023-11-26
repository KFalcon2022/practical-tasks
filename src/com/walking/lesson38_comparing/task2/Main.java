package com.walking.lesson38_comparing.task2;

import com.walking.lesson38_comparing.task2.model.Car;

import java.util.ArrayList;


/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>,
 * имплементируйте Comparable для Car таким образом,
 * чтобы машины сравнивались по полю identifier.
 * Объекты CarIdentifier предлагаю сравнивать по номеру и году (если номера почему-то совпали).
 * <p>
 * Также реализуйте сортировку коллекции машин в прямом и обратном порядке.
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<Car> cars = initCars();

		cars.sort(Car::compareTo);
		System.out.println("__________DIRECT SORTED ORDER__________");
		printAllCars(cars);

		cars.sort(Car::reverseCompareTo);
		System.out.println("__________REVERSE SORTED ORDER__________");
		printAllCars(cars);
	}

	private static void printAllCars(ArrayList<Car> cars) {
		for (Car car : cars) {
			System.out.println(car + "\n");
		}
	}

	private static ArrayList<Car> initCars() {
		ArrayList<Car> cars = new ArrayList<>();

		cars.add(new Car("A111AA", 2012, "white", true));
		cars.add(new Car("B222BB", 2019, "black", true));
		cars.add(new Car("C333CC", 2018, "yellow", true));
		cars.add(new Car("A213AB", 2022, "red", false));    //номера совпадают
		cars.add(new Car("C321BA", 2021, "purple", true));
		cars.add(new Car("A213AB", 1998, "blue", true));    //номера совпадают
		cars.add(new Car("B231BA", 2017, "green", false));
		cars.add(new Car("B331CA", 2012, "brown", true));
		cars.add(new Car("C112CA", 2020, "grey", true));
		cars.add(new Car("C322AC", 2018, "multicolor", true));
		cars.add(new Car("A313CA", 2012, "white", true));
		cars.add(new Car("B113AB", 2010, "pink", false));

		return cars;
	}
}
