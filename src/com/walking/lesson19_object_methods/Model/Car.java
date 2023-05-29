package Model;

public class Car {
    private final String brand;
    private final String color;

    protected Car(String brand, String color){
        this.brand = brand;
        this.color = color;
    }

    public String getBrand(){
        return brand;
    }

    public String getColor(){
        return color;
    }

    public String getNumber(){
        return "There is no a number";
    }

    public boolean equals(Object description) {
        if (this == description) {
            return true;
        }
        if (description == null) {
            return false;
        }
        if (!(getClass().equals(description.getClass()))) {
            return false;
        }
        Toyota toyota = (Toyota) description;
        if(!(brand.equals(toyota.getBrand()))){
            return false;
        }
        return color.equals(toyota.getColor());
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}