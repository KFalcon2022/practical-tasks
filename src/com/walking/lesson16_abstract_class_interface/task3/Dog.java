package Lesson16.Task3;

public class Dog extends Animal{
    static final String dogIdentifier = "Dog";
    public Dog()
    {
        super(dogIdentifier);
    }
    public Dog(String dogName)
    {
        super(dogIdentifier, dogName);
    }
}
