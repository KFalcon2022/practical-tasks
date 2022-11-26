package lesson13.task2Animals;

public class Task2Animal {
    public final String name;
    public final String type;

    public Task2Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    protected void sound(String mp3) {
        System.out.printf("%s (%s) says %s.\n", this.name, this.type, mp3);
    }
}
