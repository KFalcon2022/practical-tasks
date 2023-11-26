package com.walking.lesson37_collection_list.task2.model;

public class Car {
	private final String vendor;
	private final String name;
	private String regNumber;
	private String color;
	private final String vin;
	private boolean actualTechInspection;

	public Car(String vendor, String name, String regNumber, String color, String vin, boolean actualTechInspection) {
		this.vendor = vendor;
		this.name = name;
		this.regNumber = regNumber;
		this.color = color;
		this.vin = vin;
		this.actualTechInspection = actualTechInspection;
	}

	public String getVendor() {
		return vendor;
	}

	public String getName() {
		return name;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public String getColor() {
		return color;
	}

	public String getVin() {
		return vin;
	}

	public boolean isActualTechInspection() {
		return actualTechInspection;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setActualTechInspection(boolean actualTechInspection) {
		this.actualTechInspection = actualTechInspection;
	}

	@Override
	public String toString() {
		return String.format("%s %s;\ncolor: %s;\nreg.number: %s;\nvin: %s;\nactual_tech_inspection: %s;",
				vendor, name, color, regNumber, vin, actualTechInspection);
	}
}
