package com.walking.lesson32_files_1.task1.model;

public class Car {
    private String gosNumber;
    private String engineVin;
    public final Specification specification;
    private String color;

    public Car (String gosNumber, String engineVin, Specification specification, String color){
        this.gosNumber=gosNumber;
        this.engineVin=engineVin;
        this.specification=specification;
        this.color=color;
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
        return specification.getBrand()+" "+specification.getModel()+
        " color:"+getColor()+" gn:"+getGosNumber()+
        " Vin: "+getEngineVin();
    }
    public String getStringToSave(){
        StringBuilder result=new StringBuilder();
        result.append("gosNumber:"+gosNumber+",");
        result.append("engineVin:"+engineVin+",");
        result.append("model:"+specification.getModel()+
        ",brand:"+specification.getBrand()+",");
        result.append("color:"+color);
        return result.toString();
    }
}
