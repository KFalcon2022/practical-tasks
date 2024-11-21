package lesson14_polymorphism.task2;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog(), new Cow()};

        Main.voiceAnimal(animals);
    }

    static void voiceAnimal(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
