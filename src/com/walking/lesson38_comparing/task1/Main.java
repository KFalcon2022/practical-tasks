package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.model.Car;

import java.util.*;

import com.walking.lesson38_comparing.task1.Service.*;

/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>
 * реализуйте сортировку машин по:
 * · Номеру;
 * · Цвету;
 * · Году;
 * · Номеру и году.
 * <p>
 * Используйте список для хранения и сортировки коллекции машин.
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<Car> cars = initCars();
		System.out.println("_________________NOT SORTED_________________");
		printAllCars(cars);

		CarNumberComparator carNumberComparator = new CarNumberComparator();
		cars.sort(carNumberComparator);
		System.out.println("_________________SORTED BY NUMBER_________________");
		printAllCars(cars);

		CarColorComparator carColorComparator = new CarColorComparator();
		cars.sort(carColorComparator);
		System.out.println("_________________SORTED BY COLOR_________________");
		printAllCars(cars);

		CarYearComparator carYearComparator = new CarYearComparator();
		cars.sort(carYearComparator);
		System.out.println("_________________SORTED BY YEAR_________________");
		printAllCars(cars);

		Comparator<Car> carNumberAndYearComparator = new CarNumberComparator().thenComparing(carYearComparator);
		cars.sort(carNumberAndYearComparator);
		System.out.println("_________________NUMBER AND YEAR_________________");
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
		cars.add(new Car("A123AB", 2022, "red", false));
		cars.add(new Car("C321BA", 2021, "purple", true));
		cars.add(new Car("A213AB", 1998, "blue", true));
		cars.add(new Car("B231BA", 2017, "green", false));
		cars.add(new Car("B331CA", 2012, "brown", true));
		cars.add(new Car("C112CA", 2020, "grey", true));
		cars.add(new Car("C322AC", 2018, "multicolor", true));
		cars.add(new Car("A313CA", 2012, "white", true));
		cars.add(new Car("B113AB", 2010, "pink", false));

		return cars;
	}
}
