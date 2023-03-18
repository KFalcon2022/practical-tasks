package com.walking.lesson57.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private final List<Employee> employees = new ArrayList<>();
    private int vacancyAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public int getVacancyAmount() {
        return vacancyAmount;
    }

    public void setVacancyAmount(int vacancyAmount) {
        this.vacancyAmount = vacancyAmount;
    }
}
