package com.walking.lesson57_stream_collect_collector.model;

import java.util.List;

public class Department {
    private String name;
    private int vacancyAmount;
    private List<Employee> employees;

    public Department(String name, int vacancyAmount, List<Employee> employees) {
        this.name = name;
        this.vacancyAmount = vacancyAmount;
        this.employees = employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVacancyAmount(int vacancyAmount) {
        this.vacancyAmount = vacancyAmount;
    }

    public void setEmployees(List<Employee> employees) {
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
    public String toString(){
        return name;
    }
}
