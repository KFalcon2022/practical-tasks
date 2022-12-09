package com.walking.lesson21_immutable_object.model;

public class CarFeatures {
	
	private final String vin;
	private final String brand;
	private final String engineType;
	
	public CarFeatures(String vin, String brand, String engineType) {
		this.vin = vin;
		this.brand = brand;
		this.engineType = engineType;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarFeatures that = (CarFeatures) o;
		
		return vin.equals(that.vin) && brand.equals(that.brand) && engineType.equals(that.engineType);
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
		return String.format("CarProperties: vin = %s, brand = %s, enginType = %s", vin, brand, engineType);
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
}
