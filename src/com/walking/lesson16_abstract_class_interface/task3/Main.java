package com.walking.lesson16_abstract_class_interface.task3;

import com.walking.lesson16_abstract_class_interface.task3.model.Animal;
import com.walking.lesson16_abstract_class_interface.task3.model.Cat;
import com.walking.lesson16_abstract_class_interface.task3.model.Cow;
import com.walking.lesson16_abstract_class_interface.task3.model.Dog;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[]{new Dog(), new Cat(), new Cow()};
        speak(animals);
    }

    private static void speak(Animal[] animals) {
        for (Animal animal : animals) {
            animal.sound();
        }
    }

}
