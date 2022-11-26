package lesson14.task2Animals;

public class Task2Dog extends Task2Animal {
    public Task2Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.printf("%s says woof.\n", this.name);
    }
}
