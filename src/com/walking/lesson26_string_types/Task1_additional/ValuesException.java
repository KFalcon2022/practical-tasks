package Lesson26.Task1_additional;

public class ValuesException extends NullPointerException {
    public ValuesException(String message, String exmessage)
    {
        super("Wrong length/width: " + message + " or: " + exmessage);
    }
}
