package com.walking.lesson21_immutable_object.model;

public class Car {
	
	private String ownerName;
	private final CarFeatures carFeatures;
	
	public Car(CarFeatures carFeatures, String ownerName) {
		this.carFeatures = carFeatures;
		this.ownerName = ownerName;
	}
	
	public Car(CarFeatures carFeatures) {
		this(carFeatures, "");
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		
		return carFeatures.equals(car.carFeatures);
	}
	
	@Override
	public int hashCode() {
		return carFeatures.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("Car:\n ownerName = %s\n" + carFeatures, ownerName);
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
