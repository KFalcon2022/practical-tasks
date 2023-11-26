package Lesson21;

public class CarCharException extends NullPointerException {
    public CarCharException (String message, String carNumber)
    {
        super(message + "[" + carNumber + "]");
    }
}
