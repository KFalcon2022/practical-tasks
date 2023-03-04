package com.walking.lesson21_immutable_object.model;

import java.util.Locale;

public final class Car {
	private final String vendor;
	private final String model;
	private final String issueYear;
	private final String color;
	private final String vin;
	private final String regNumber;

	public Car(String vendor, String model, String issueYear, String color, String regNumber, String vin) {
		this.vendor = vendor;
		this.model = model;
		this.issueYear = issueYear;
		this.color = color;
		this.vin = vin;
		this.regNumber = regNumber;
	}

	public String getVendor() {
		String copyVendor = vendor;
		return copyVendor;
	}

	public String getModel() {
		String copyModel = model;
		return copyModel;
	}

	public String getIssueYear() {
		String copyIssueYear = issueYear;
		return copyIssueYear;
	}

	public String getColor() {
		String copyColor = color;
		return copyColor;
	}

	public String getRegNumber() {
		String copyRegNumber = regNumber;
		return copyRegNumber;
	}

	public String getVin() {
		String copyVin = vin;
		return copyVin;
	}

	@Override
	public int hashCode(){
		int result = (vin != null) && (regNumber != null) ?
				(regNumber + vin).hashCode() : 0;
		return result * 31;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == this) {
			return true;
		}

		if (o == null || o.getClass() != getClass()) {
			return false;
		}

		return this.regNumber.equals(((Car) o).getRegNumber())
				&& this.vin.equals(((Car) o).getVin());
	}
}
