package com.walking.lesson19_object_methods.model;

public class Mark {
    private String[] markArray = {
            "Audi",
            "BMW",
            "Volvo",
            "Lada",
            "Suzuki",
            "Renault",
            "Kia",
            "Mazda",
    };

    public String setMark() {
        return markArray[(int) (Math.random() * markArray.length)];
    }
}
