package com.walking.lesson19_object_methods.model;

import java.util.Objects;
public class Car {
    private String number;
    private String model;

    public Car(String number, String model) {
        this.number = number;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Number:"+this.number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null || !(obj instanceof Car car) ){
            return false;
        }
        return Objects.equals(car.number, number )&&Objects.equals(car.model, model);
    }

    @Override
    public int hashCode() {
        return 31 * number.hashCode() + model.hashCode();
    }
}


