package Lesson18.getClassTask;

public class Animal implements Speakable{
    private final String className;
    private String sound;
    protected Animal(String className, String sound)
    {
        this.className = className;
        this.sound = sound;
    }
    protected void getSound()
    {
        System.out.println(sound);
    }
}