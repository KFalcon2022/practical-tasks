package com.walking.lesson47_method_reference.task_3;

import java.util.HashMap;

public class FilterService {
    private final HashMap<String, Filter> filters = new HashMap<>();

    public FilterService() {
        addFilters();
    }

    public HashMap<String, Filter> getAll() {
        return filters;
    }

    private void addFilters() {
        filters.put("n", new Filter("number of car", "number", this::filterByNumber));
        filters.put("s", new Filter("substring in car number", "number", this::filterBySubstring));
        // search by brand field instead of searching by color field, as in the task description
        filters.put("b", new Filter("brand of car", "word", this::filterByBrand));
        filters.put("y", new Filter("years period of produced", "begin-end", this::filterByYear));
    }

    private boolean filterByNumber(Car car, String target) {
        return car.getSerialNumber() == Integer.parseInt(target);
    }

    private boolean filterBySubstring(Car car, String target) {
        return String.valueOf(car.getSerialNumber()).contains(target);
    }

    private boolean filterByBrand(Car car, String target) {
        return car.getBrand().equalsIgnoreCase(target);
    }

    private boolean filterByYear(Car car, String target) {
        int[] years = parseYears(target);
        // some logic of validate correct years period

        return car.getYearOfProduced() >= years[0] && car.getYearOfProduced() <= years[1];
    }

    private int[] parseYears(String input) {
        String[] str = input.split("-");

        return new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])};
    }
}
