package com.walking.lesson21_immutable_object.model;

public record CarProperties(String VIN, String brand, String engineType) {
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CarProperties that = (CarProperties) o;
		return VIN.equals(that.VIN) && brand.equals(that.brand) && engineType.equals(that.engineType);
	}
	
	@Override
	public String toString() {
		return "CarProperties{" +
				"VIN='" + VIN + '\'' +
				", brand='" + brand + '\'' +
				", engineType='" + engineType + '\'' +
				'}';
	}
}
