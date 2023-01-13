package com.walking.lesson37.Task1;

public class Counter {
    private final String name;
    private final String unit;
    private double value;

    public Counter(String name, String unit, double value){
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public String getName() {return name;}

    public String getUnit() {return unit;}

    public double getValue() {return value;}

    public void setValue(double value) {this.value = value;}

    @Override
    public String toString(){
        return "%s %f".formatted(getName(), getValue());
    }

    @Override
    public int hashCode(){
        return name.hashCode() * 1001 + unit.hashCode() * 555;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || o.getClass() != getClass()) return false;
        return this == o || hashCode() == o.hashCode();
    }
}
