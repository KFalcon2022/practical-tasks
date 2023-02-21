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
		this.vendor = vendor.toLowerCase(Locale.ROOT).replace(" ", "_");
		this.model = model.toLowerCase(Locale.ROOT).replace(" ", "_");
		this.issueYear = issueYear;
		this.color = color.toLowerCase(Locale.ROOT).replace(" ", "_");
		this.vin = vin.toLowerCase().replace(" ", "").replace("-", "");
		this.regNumber = regNumber.toLowerCase(Locale.ROOT);
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
		int result = ((vendor !=null) && (model != null) && (regNumber != null)) ?
											(vendor + model + regNumber).hashCode() : 0;
		return result * 31;
	}



}
