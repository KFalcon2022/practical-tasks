package com.walking.lesson32_files_1.task3;

import com.walking.lesson32_files_1.task3.model.Car;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CarRepository {
	public Car[] getCars() {
		return cars;
	}

	private Car[] cars;
	public CarRepository(Car [] cars) {
		this.cars = cars;
	}

	public Car[] importCarCatalogFromFile(String path){

		StringBuilder inputData = new StringBuilder();

		try (FileInputStream fin = new FileInputStream(path)) {
			int i;
			while ((i = fin.read()) != -1) {
				inputData.append((char) i);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		//Считаем количество строк, чтоб знать какой размерности массив создавать.
		int stringCounter = 0;
		for (int i = 0; i < inputData.length(); i++) {
			if (inputData.charAt(i) == '\n') {
				stringCounter++;
			}
		}

		Car[] cars = new Car[stringCounter];
		String[] subStrObj = inputData.toString().split("\n"); //делим построчно
		String number = "";
		int year;
		String color = "";
		boolean actualTechnicalInspection;

		for (int i = 0; i < cars.length; i++){
			String[] params = subStrObj[i].split("/");  //делим на слова (параметры) по разделителю
			number = params[0];
			year = Integer.parseInt(params[1]);
			color = params[2];
			if (params[3].equals("actual")) {
				actualTechnicalInspection = true;
			}else {
				actualTechnicalInspection = false;
			}
			cars[i] = new Car(number, year, color, actualTechnicalInspection);
		}
		this.cars = cars;
		return cars;
	}

	public void exportCarCatalogToFile(String path){
		StringBuilder text = new StringBuilder();

		for (Car car : cars) {
			text.append(car.stringForFile()).append("\n");
		}

		try (FileOutputStream fos = new FileOutputStream(path))
		{
			byte[] buffer = text.toString().getBytes();

			fos.write(buffer, 0, buffer.length);
			System.out.println("The file has been written.");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addCar (Car car){
		Car[] carsWithAdded = new Car[cars.length + 1];
		for (int i = 0; i < cars.length; i++){
			carsWithAdded[i] = cars[i];
		}
		carsWithAdded[cars.length] = car;
		this.cars = carsWithAdded;
	}

	public void removeCar (String number){
		Car[] carsWithoutRemoved = new Car[cars.length - 1];
		if (findCar(number)){
			int i = 0;
			int j = 0;
			while (i < cars.length) {
				if (cars[i].getNumber().equals(number)) {
					i++;
				}
				carsWithoutRemoved[j] = cars[i];
				i++;
				j++;
			}
			this.cars = carsWithoutRemoved;
			System.out.println("Car with number: " + number + " is deleted!");
			return;
		}
		System.out.println("Car with number: " + number + " is not found!");

	}

	public void editCar (String number, Car car){
		Car [] editingCars = new Car[cars.length];
		if (findCar(number)){
			for (int i = 0; i < cars.length; i++){
				if (cars[i].getNumber().equals(number)){
					editingCars[i] = car;
				}else {
					editingCars[i] = cars[i];
				}
			}
		this.cars = editingCars;
		System.out.println("Editing is done!");
		}else {
			System.out.println("Car with number: " + number + " is not found!");
		}

	}

	private boolean findCar (String number){
		for (Car car:cars) {
			if (car.getNumber().equals(number)) {
				return true;
			}
		}
		return false;
	}
}
