package com.walking.lesson58_collection_lamda_param;

import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private int vacancyAmount;
    private List<Employee> employees;

    public Department(String name, int vacancyAmount, List<Employee> employees) {
        this.name = name;
        this.vacancyAmount = vacancyAmount;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public int getVacancyAmount() {
        return vacancyAmount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
