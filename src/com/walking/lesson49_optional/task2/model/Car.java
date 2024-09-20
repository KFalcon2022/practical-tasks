package com.walking.lesson49_optional.task2.model;

public class Car {
    private String gosNumber;
    private String engineVin;
    public final Specification specification;
    private String color;
    private Human owner;
    
    public Car (String gosNumber, String engineVin, Specification specification, String color, Human owner){
        this.gosNumber=gosNumber;
        this.engineVin=engineVin;
        this.specification=specification;
        this.color=color;
        this.owner=owner;
    }
    
    //#region Setters Getters
    public String getGosNumber(){
        return this.gosNumber;
    }

    public void setGosNumber(String newGosNumber){
        this.gosNumber=newGosNumber;
    }

    public String getEngineVin(){
        return this.engineVin;
    }

    public void setEngineVin(String newEngineVin){
        this.engineVin=newEngineVin;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String newColor){
        this.color=newColor;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
    //#endregion Setters Getters
    
    @Override
    public boolean equals(Object o){
        if (this==o){
            return true;
        }
        if (o==null){
            return false;
        }
        if (!(o instanceof Car)){
            return false;
        }

        Car car=(Car)o;
        if (this.gosNumber.equals(car.getGosNumber()) 
        & this.engineVin.equals(car.getEngineVin())){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int result=this.gosNumber==null ? 0 : this.gosNumber.hashCode();
        result=29*result+(this.engineVin==null ? 0 : this.engineVin.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return String.format(
        "Марка: %s\nМодель: %s\nГод: %d\nЦвет: %s\nГос. номер: %s\nVIN: %s\n",
        specification.getBrand(),
        specification.getModel(),
        specification.getYear(),
        getColor(),
        getGosNumber(),
        getEngineVin()
        );

    }
}
