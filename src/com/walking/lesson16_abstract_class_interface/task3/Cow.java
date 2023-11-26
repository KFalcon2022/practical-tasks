package Lesson16.Task3;

public class Cow extends Animal {
    static final String cowIdentifier = "Cow";
    public Cow()
    {
        super(cowIdentifier);
    }
    public Cow(String cowName)
    {
        super(cowIdentifier, cowName);
    }
}
