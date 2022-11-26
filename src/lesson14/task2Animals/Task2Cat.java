package lesson14.task2Animals;

public class Task2Cat extends Task2Animal {
    public Task2Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.printf("%s says meow.\n", this.name);
    }
}
