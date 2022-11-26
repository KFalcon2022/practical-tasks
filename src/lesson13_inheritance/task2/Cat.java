package lesson13_inheritance.task2;

class Cat extends Animal {
    Cat (String shout) {
        super(shout);
    }

    void meow() {
        sound();
    }
}
