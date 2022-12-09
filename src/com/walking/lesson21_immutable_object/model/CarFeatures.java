package com.walking.lesson21_immutable_object.model;

public record CarFeatures(String VIN, String brand, String engineType) {
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarFeatures that = (CarFeatures) o;
		
		return VIN.equals(that.VIN) && brand.equals(that.brand) && engineType.equals(that.engineType);
	}
	
	@Override
	public int hashCode() {
		int result = VIN.hashCode();
		result = 31 * result + brand.hashCode();
		result = 31 * result + engineType.hashCode();
		
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("CarProperties: VIN = %s, brand = %s, enginType = %s", VIN, brand, engineType);
	}
}
