package Model;

public class BMW extends Car{
    private final String number = "x777xo";
    public BMW(){
        super("BMW", "red");
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
        BMW bmw = (BMW) description;
        return this.number.equals(bmw.number);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        return  result;
    }
}