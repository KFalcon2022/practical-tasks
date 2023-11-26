package Lesson25.Task2.StaticInner;

import java.util.NoSuchElementException;

public class AnimalException extends NoSuchElementException {
    public AnimalException(String animal)
    {
        super("No such Animal :" + animal);
    }
}
