package Model;

public class Honda extends Car{
    private final String number = "x888xo";
    public Honda(){
        super("Honda", "black");
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
        Honda honda = (Honda) description;
        return this.number.equals(honda.number);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        return  result;
    }
}