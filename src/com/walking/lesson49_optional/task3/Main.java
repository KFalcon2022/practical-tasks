package com.walking.lesson49_optional.task3;

import java.util.Optional;

import com.walking.lesson49_optional.task3.model.Animal;
import com.walking.lesson49_optional.task3.model.Cat;
import com.walking.lesson49_optional.task3.model.Cow;
import com.walking.lesson49_optional.task3.model.Dog;

/**
 * Реализуйте абстрактный класс «Животное», содержащий абстрактный метод sound().
 * Также реализуйте трех наследников: кота, собаку и корову.
 * <p>
 * Реализуйте метод, выводящий в консоль сообщение вида
 * <p>
 * «Это %тип животного%, он (она) говорит %результат метода sound()%»
 * Использование условных конструкций (if-else, switch-case, тернарный оператор)
 * и хранение типа наследника в виде поля недопустимо.
 * <p>
 * Подсказка: используйте or().
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals=new Animal[3];
        animals[0]=new Cat();
        animals[1]=new Dog();
        animals[2]=new Cow();
        for (Animal animal : animals) {
            Optional.ofNullable(animal)
            .filter(pet->pet.getClass().equals(Cat.class))
            .or(()->Optional.ofNullable(animal).filter(pet->pet.getClass().equals(Dog.class)))
            .or(()->Optional.ofNullable(animal).filter(pet->pet.getClass().equals(Cow.class)))
            .ifPresent(s->System.out.print("Это "+s.getClass().getSimpleName()))
            ;
            System.out.println(animal.sound());
        }
    }
}
