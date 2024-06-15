package com.walking.lesson57_stream_collect_collector.model;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getVacancyAmount() {
        return vacancyAmount;
    }

    public void setVacancyAmount(int vacancyAmount) {
        this.vacancyAmount = vacancyAmount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", vacancyAmount=" + vacancyAmount +
                ", employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;

        return getVacancyAmount() == that.getVacancyAmount()
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getEmployees(), that.getEmployees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVacancyAmount(), getEmployees());
    }
}
