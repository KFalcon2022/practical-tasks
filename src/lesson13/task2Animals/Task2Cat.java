package lesson13.task2Animals;

public class Task2Cat extends Task2Animal {
    public final String soundOfThis;

    public Task2Cat(String name, String type) {
        super(name, type);
        this.soundOfThis = "meow";
    }

    public void meow() {
        super.sound(soundOfThis);
    }
}
