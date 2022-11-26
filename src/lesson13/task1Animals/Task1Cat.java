package lesson13.task1Animals;

import lesson13.task1Animals.Task1Animal;

public class Task1Cat extends Task1Animal {
    private Task1Cat() {
        System.out.println("I'm a cat.");
    }

    public Task1Cat(String color) {
        this();
        System.out.printf("I'm a %s cat.\n", color);
    }
}
