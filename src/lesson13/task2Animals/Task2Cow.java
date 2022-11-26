package lesson13.task2Animals;

public class Task2Cow extends Task2Animal {
    public final String soundOfThis;

    public Task2Cow(String name, String type) {
        super(name, type);
        this.soundOfThis = "moo";
    }

    public void moo() {
        super.sound(soundOfThis);
    }
}
