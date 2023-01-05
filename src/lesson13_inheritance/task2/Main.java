package lesson13_inheritance.task2;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("meow"), new Dog("woof"), new Cow("moo")};

        Main.voiceAnimal(animals);
    }

    static void voiceAnimal(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
