package Lesson25.Task2.StaticInner;

public class Animal implements Speakable {
    public Animal() {}
    public String sound() {
        throw new AnimalException("Animal");
    }
    public String toString()
    {
        return new AnimalException("abstract Animal").getMessage();
    }

    public String quickSound(String chosenAnimal)
    {
        if (chosenAnimal.toLowerCase().contains("cat"))
           return new Animal.Cat().toString();
        if (chosenAnimal.toLowerCase().contains("dog"))
            return new Animal.Dog().toString();
        if (chosenAnimal.toLowerCase().contains("cow"))
            return new Animal.Cow().toString();
        throw new AnimalException(chosenAnimal);
    }
    public static class Cat implements Speakable {
        @Override
        public String toString()
        {
            return "Cat: " + CAT_SOUND;
        }
    }
    public static class Dog implements Speakable {
        public String toString()
        {
            return "Dog: " + DOG_SOUND;
        }
    }
    public static class Cow implements Speakable {
        @Override
        public String toString()
        {
            return "Cow: " + COW_SOUND;
        }
    }
}
