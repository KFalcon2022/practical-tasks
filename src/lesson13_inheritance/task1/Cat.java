package lesson13_inheritance.task1;

class Cat extends Animal {
    private Cat() {
        System.out.println("I’m a cat.");
    }

    public Cat(String color) {
        this();
        System.out.println("I'm a " + color + " cat.");
    }
}
