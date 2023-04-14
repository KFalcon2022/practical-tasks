package Lesson25.Task2.InnerClass;

import Lesson18.getClassTask.Dog;

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
           return new Animal().new Cat().toString();
        if (chosenAnimal.toLowerCase().contains("dog"))
            return new Animal().new Dog().toString();
        if (chosenAnimal.toLowerCase().contains("cow"))
            return new Animal().new Cow().toString();
        throw new AnimalException(chosenAnimal);
    }
    public class Cat implements Speakable {
        public Cat() {}
        public String sound()
        {
            return new Cat().toString();
        }
        @Override
        public String toString()
        {
            return CAT_SOUND;
        }
    }
    public class Dog implements Speakable {
        public Dog() {}
        public String sound()
        {
            return new Dog().toString();
        }
        @Override
        public String toString()
        {
            return DOG_SOUND;
        }
    }
    public class Cow implements Speakable {
        public Cow() {}
        public String sound()
        {
            return new Cow().toString();
        }
        @Override
        public String toString()
        {
            return COW_SOUND;
        }
    }
}
