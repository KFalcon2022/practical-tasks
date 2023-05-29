package Model;

public class Toyota extends Car{
    private final String number = "x666xo";
    public Toyota(){
        super("Toyota", "white");
    }

    @Override
    public String getNumber(){
        return number;
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
        return this.number.equals(toyota.number);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        return  result;
    }
}