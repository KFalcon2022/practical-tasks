package Lesson16.Task3;

public class Cat extends Animal{
    static final String catIdentifier = "Cat";
    public Cat()
    {
        super(catIdentifier);
    }
    public Cat(String catName)
    {
        super(catIdentifier, catName);
    }
}
