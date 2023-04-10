package Lesson18.instanceofTask;

public class Animal {
    private String sound;
    public Animal ()
    {}
    protected Animal(String sound)
    {
        this.sound = sound;
    }
    protected void getSound()
    {
        System.out.println(sound);
    }

    public static void diffSound(Animal animal)
    {
        if (animal instanceof Cat cat)
            cat.meow();
        if (animal instanceof Dog dog)
            dog.woof();
        if (animal instanceof Cow cow)
            cow.moo();
    }
}