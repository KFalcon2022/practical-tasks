package com.walking.lesson38_comparing.task1.model;

public class Car {
	//    Уникальным идентификатором будет объект immutable класса CarIdentifier
	private final CarIdentifier identifier;

	private String color;
	private boolean actualTechnicalInspection;

	public Car(String number, int year, String color, boolean actualTechnicalInspection) {
		this(new CarIdentifier(number, year), color, actualTechnicalInspection);
	}

	public Car(CarIdentifier identifier, String color, boolean actualTechnicalInspection) {
		this.identifier = identifier;
		this.color = color;
		this.actualTechnicalInspection = actualTechnicalInspection;
	}

	public CarIdentifier getIdentifier() {
		return identifier;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isActualTechnicalInspection() {
		return actualTechnicalInspection;
	}

	public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
		this.actualTechnicalInspection = actualTechnicalInspection;
	}

	@Override
	public String toString() {
		return """
				number: %s
				year: %d
				color: %s
				actualTechnicalInspection: %s
				""".formatted(
				identifier.getNumber(), identifier.getYear(), color,
				actualTechnicalInspection ? "actual" : "not actual");
	}
}
