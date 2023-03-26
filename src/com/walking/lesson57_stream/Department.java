package com.walking.lesson57_stream;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;
    private int vacancyAmount;

    public Department(String name, int vacancyAmount, List<Employee> employees) {
        this.name = name;
        this.vacancyAmount = vacancyAmount;
        this.employees = employees;
    }

    public String getName() {
        return this.name;
    }

    public int getVacancyAmount() {
        return this.vacancyAmount;
    }
    public List<Employee> getEmployees() {
        return this.employees;
    }

    @Override
    public String toString(){
        return "%s (%d employees)".formatted(this.name, this.employees.size());
    }

    public int getAvailablePositions() {
        return getVacancyAmount() - getEmployees().size();
    }
    public long getAvailablePercentage() {
        return Math.round(100.0 * Long.valueOf(getAvailablePositions()).doubleValue() / Long.valueOf(getVacancyAmount()).doubleValue());
    }
}