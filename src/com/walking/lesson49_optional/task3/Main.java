package com.walking.lesson49_optional.task3;

import com.walking.lesson49_optional.task3.model.Animal;
import com.walking.lesson49_optional.task3.model.Cat;
import com.walking.lesson49_optional.task3.model.Cow;
import com.walking.lesson49_optional.task3.model.Dog;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        ArrayList<Animal> animals = getAnimalList();
        displayAnimalMessage(animals);
    }
    private static ArrayList<Animal> getAnimalList(){
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Cow());
        animals.add(new Animal() {
            @Override
            public String sound() {
                return "Wow";
            }
        });
        return animals;
    }
    private static void displayAnimalMessage(ArrayList<Animal> animals){
        for (Animal animal:animals){
            Optional.ofNullable(animal)
                    .filter(a->Cat.class.equals(a.getClass()))
                    .map(a->new AbstractMap.SimpleEntry<>("Cat",a))
                    .or(()->Optional.ofNullable(animal)
                            .filter(a->Dog.class.equals(a.getClass()))
                            .map(a->new AbstractMap.SimpleEntry<>("Dog",a)))
                    .or(()->Optional.ofNullable(animal)
                            .filter(a->Cow.class.equals(a.getClass()))
                            .map(a->new AbstractMap.SimpleEntry<>("Cow",a)))
                    .ifPresentOrElse(
                            s-> System.out.printf("Это %s, он(она) говорит %s%n",
                                    s.getKey(),s.getValue().sound()),
                            ()->{
                                throw new RuntimeException("Unknown type of animal or null");
                            }
                    );
        }
    }
}
