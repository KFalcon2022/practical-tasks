package lesson13.task2Animals;

public class Task2Dog extends Task2Animal {
    public final String soundOfThis;

    public Task2Dog(String name, String type) {
        super(name, type);
        this.soundOfThis = "woof";
    }

    public void woof() {
        super.sound(soundOfThis);
    }
}
