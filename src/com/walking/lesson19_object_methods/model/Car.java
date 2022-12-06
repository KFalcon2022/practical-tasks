package com.walking.lesson19_object_methods.model;

import java.util.Objects;

public class Car {
	
	private final String VIN;
	private final String brand;
	private final String engineType;
	private String ownerName;
	
	public Car(String VIN, String brand, String engineType, String ownerName) {
		this.VIN = VIN;
		this.brand = brand;
		this.engineType = engineType;
		this.ownerName = ownerName;
	}
	
	public Car(String VIN, String brand, String engineType) {
		this(VIN, brand, engineType, "-");
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return VIN.equals(car.VIN) && brand.equals(car.brand) && engineType.equals(car.engineType);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(VIN, brand, engineType);
	}
	
	@Override
	public String toString() {
		return "Car{" +
				"VIN='" + VIN + '\'' +
				", brand='" + brand + '\'' +
				", engineType='" + engineType + '\'' +
				"}\n" +
				"ownerName=" + ownerName;
	}
	
	public String getVIN() {
		return VIN;
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
