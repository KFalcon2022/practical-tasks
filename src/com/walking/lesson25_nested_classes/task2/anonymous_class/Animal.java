package Lesson25.Task2.Anonymous;

public class Animal implements Speakable{
    public Animal() {}
    @Override
    public String sound() {
        throw new AnimalException(new Animal().toString());
    }

    public String toString()
    {
        return "Animal";
    }
}
