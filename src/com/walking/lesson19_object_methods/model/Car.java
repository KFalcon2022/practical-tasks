package com.walking.lesson19_object_methods.model;

public class Car {
	
	private final String vin;
	private final String brand;
	private final String engineType;
	private String ownerName;
	
	public Car(String vin, String brand, String engineType, String ownerName) {
		this.vin = vin;
		this.brand = brand;
		this.engineType = engineType;
		this.ownerName = ownerName;
	}
	
	public Car(String vin, String brand, String engineType) {
		this(vin, brand, engineType, "");
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Car car = (Car) o;
		
		return vin.equals(car.vin) && brand.equals(car.brand) && engineType.equals(car.engineType);
	}
	
	@Override
	public int hashCode() {
		int result = vin.hashCode();
		result = 31 * result + brand.hashCode();
		result = 31 * result + engineType.hashCode();
		
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("Car: VIN = %s, brand = %s, enginType = %s, ownerName = %s", vin, brand, engineType, ownerName);
	}
	
	public String getVin() {
		return vin;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getEngineType() {
		return engineType;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
