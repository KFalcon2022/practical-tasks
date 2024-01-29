package com.walking.lesson37_collection_list.task1.model;

public class Counter {
    private final String name;
    private String unit;
    private int value=0;

    public Counter (String name, String unit){
        this.name=name;
        this.unit=unit;
    }
    public String getName() {
        return name;
    }
    public String getUnit(){
        return unit;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        if (value<0)
            System.out.println("You entered incorrect value!");
        else
            this.value=value;
    }
}
