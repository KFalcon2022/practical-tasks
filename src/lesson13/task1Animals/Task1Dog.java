package lesson13.task1Animals;

import lesson13.task1Animals.Task1Animal;

public class Task1Dog extends Task1Animal {
    private Task1Dog() {
        System.out.println("I'm a dog.");
    }

    public Task1Dog(String color) {
        this();
        System.out.printf("I'm a %s dog.\n", color);
    }
}
