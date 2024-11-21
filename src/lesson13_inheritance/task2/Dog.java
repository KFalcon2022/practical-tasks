package lesson13_inheritance.task2;

class Dog extends Animal {
    Dog (String shout) {
        super(shout);
    }

    void woof() {
        sound();
    }
}
