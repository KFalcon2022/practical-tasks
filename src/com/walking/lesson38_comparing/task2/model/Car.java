package com.walking.lesson38_comparing.task2.model;

public class Car implements Comparable<Car> {
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

	@Override
	public int compareTo(Car o) {

		if (identifier.getNumber().compareTo(o.identifier.getNumber()) == 0) {
			return Integer.compare(getIdentifier().getYear(), o.identifier.getYear());
		}

		return identifier.getNumber().compareTo(o.identifier.getNumber());
	}

	public int reverseCompareTo(Car o) {
		int result = identifier.getNumber().compareTo(o.identifier.getNumber());
		if (result == 0) {
			result = Integer.compare(getIdentifier().getYear(), o.identifier.getYear());
		}
		switch (result) {
			case (1) -> {
				result = -1;
			}
			case (-1) -> {
				result = 1;
			}
		}
		return result;
	}
}
