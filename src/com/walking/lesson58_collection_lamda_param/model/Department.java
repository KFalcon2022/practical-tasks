package com.walking.lesson58_collection_lamda_param.model;

import java.util.List;

public class Department {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int vacancyAmount;
    public int getVacancyAmount() {
        return vacancyAmount;
    }

    public void setVacancyAmount(int vacancyAmount) {
        this.vacancyAmount = vacancyAmount;
    }

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(String name, int vacancyAmount, List<Employee> employees){
        this.name=name;
        this.vacancyAmount=vacancyAmount;
        this.employees=employees;
    }
}
