package lesson13_inheritance.task1;

class Dog extends Animal {
    private Dog() {
        System.out.println("I’m a dog.");
    }

    public Dog(String color) {
        this();
        System.out.println("I'm a " + color + " dog.");
    }
}
