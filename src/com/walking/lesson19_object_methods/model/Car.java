package com.walking.lesson19_object_methods.model;

public class Car {
    private String gosNumber;
    private String engineVin;
    private String brand;
    private String model;
    private String color;

    public Car (String gosNumber, String engineVin){
        this.gosNumber=gosNumber;
        this.engineVin=engineVin;
    }
    public Car (String gosNumber, String engineVin, String brand, String model, String color){
        this(gosNumber, engineVin);
        this.brand=brand;
        this.model=model;
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

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String newBrand){
        this.brand=newBrand;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String newModel){
        this.model=newModel;
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
        return getBrand()+" "+getModel()+" color:"+getColor()+" gn:"+getGosNumber()+
        " Vin: "+getEngineVin();
    }
}
