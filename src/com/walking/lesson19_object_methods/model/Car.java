package com.walking.lesson19_object_methods.model;

import com.walking.lesson19_object_methods.Main;

import java.util.Locale;
import java.util.Objects;

public class Car {

	private String vendor;
	private String model;
	private String issueYear;
	private String color;
	private String vin;
	private String regNumber;

	public Car(String vendor, String model, String issueYear, String color, String regNumber, String vin) {
		this.vendor = vendor.toLowerCase(Locale.ROOT).replace(" ", "_").trim();
		this.model = model.toLowerCase(Locale.ROOT).replace(" ", "_").trim();
		this.issueYear = issueYear.trim();
		this.color = color.toLowerCase(Locale.ROOT).replace(" ", "_").trim();
		this.vin = vin.toLowerCase().replace(" ", "").replace("-", "").trim();
		this.regNumber = regNumber.toLowerCase(Locale.ROOT).trim();
	}

	public String getVendor() {
		return vendor;
	}

	public String getModel() {
		return model;
	}

	public String getIssueYear() {
		return issueYear;
	}

	public String getColor() {
		return color;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public String getVin() {
		return vin;
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
