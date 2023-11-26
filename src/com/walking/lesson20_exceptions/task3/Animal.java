package Lesson20.Task3;

public class Animal implements Speakable {
    private final String className;
    private String sound;
    public Animal(String className, String sound)
    {
        this.className = className;
        this.sound = sound;
    }
    public void getSound()
    {
        System.out.println(sound);
    }

    @Override
    public String toString() {
        return """
                \n
                Animal name: %s
                Animal sound: %s
                """.formatted(className, sound);
    }
}