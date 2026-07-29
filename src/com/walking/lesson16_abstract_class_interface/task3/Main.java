package com.walking.lesson16_abstract_class_interface.task3;


import com.walking.lesson16_abstract_class_interface.task3.model.Animal;
import com.walking.lesson16_abstract_class_interface.task3.model.Cat;
import com.walking.lesson16_abstract_class_interface.task3.model.Cow;
import com.walking.lesson16_abstract_class_interface.task3.model.Dog;

/**
 * Реализуйте любую задачу из уроков о наследовании или полиморфизме с использованием новых знаний.
 * Выбирайте инструмент с умом.
 * <p>
 * В качестве задачи выбрано задание про животных
 * <a href="https://github.com/KFalcon2022/lessons/blob/master/lessons/java-core/013/Inheritance.%20Keywords%20extends%20and%20super.%20Access%20modifier%20protected.md">...</a>>
 */
public class Main {

    public static void main(String[] args) {

        Animal[] animals = {new Cat("Я - тигр!"), new Dog("Я - волк!"), new Cow("Я - просто корова. Муууу.")};

        for (Animal animal : animals){
            animal.sound();
        }
    }
}
