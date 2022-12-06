package com.walking.lesson21_immutable_object.model;

import java.util.Objects;

public class Car {
	
	private String ownerName;
	private CarProperties carProperties;
	
	public Car(CarProperties carProperties, String ownerName) {
		this.carProperties = carProperties;
		this.ownerName = ownerName;
	}
	
	public Car(CarProperties carProperties) {
		this(carProperties, "-");
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return carProperties.equals(car.carProperties);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(carProperties);
	}
	
	@Override
	public String toString() {
		return "Car{" +
				"ownerName='" + ownerName + '\'' +
				", carProperties=" + carProperties +
				'}';
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
