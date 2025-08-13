package lesson13_inheritance.task2;

class Cow extends Animal {
    Cow (String shout) {
        super(shout);
    }

    void moo() {
        sound();
    }
}
