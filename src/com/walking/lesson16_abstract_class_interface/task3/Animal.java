package Lesson16.Task3;

abstract public class Animal implements speakable{
    String animal = "Unidentified creature";
    String name = "Unnamed " + animal;
    public Animal(String animal)
    {
        this.animal = animal;
        speakable.sound(this.animal);
    }
    public Animal(String animal, String name)
    {
        this.animal = animal;
        if (name != null && (name.length() > 2))
        {
            this.name = name;
            speakable.sound(this.animal, this.name);
        }
        else
            speakable.sound(this.animal);
    }
}

