package Lesson26.Task2;

public class StrException extends IllegalArgumentException{
    public StrException(String argument){
        super("Wrong String argument:" + argument);
    }
}
