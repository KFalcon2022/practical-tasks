package com.walking.lesson49_optional.task3;

import com.walking.lesson49_optional.task3.model.Animal;
import com.walking.lesson49_optional.task3.model.Cat;
import com.walking.lesson49_optional.task3.model.Cow;
import com.walking.lesson49_optional.task3.model.Dog;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        getInfo(new Cat());
        getInfoV2(new Dog());
    }

    public static void getInfo(Animal animal) {
        Optional.ofNullable(animal)
                .ifPresent(an -> System.out.printf("Это %s, он (она) говорит %s \n".formatted(an.getClass().getSimpleName(), an.sound())));
    }

    public static void getInfoV2(Animal animal) {

        //Ну, допустим, мы можем вот такую хрень сделать, если нужен какой-то уникальный вывод, а не только со сменой двух параметров...
        Optional.empty()
                .or(() -> Optional.ofNullable(animal).filter(a -> a instanceof Dog)
                        .map(a -> {
                            System.out.printf("Это %s, он (она) говорит %s \n".formatted(a.getClass().getSimpleName(), a.sound()));
                            ((Dog) a).onlyDogMethod();
                            return a;
                        }))
                .or(() -> Optional.ofNullable(animal).filter(a -> a instanceof Cat)
                        .map(a -> {
                            System.out.printf("Это %s, он (она) говорит %s \n".formatted(a.getClass().getSimpleName(), a.sound()));
                            return a;
                        }))
                .or(() -> Optional.ofNullable(animal).filter(a -> a instanceof Cow)
                        .map(a -> {
                            System.out.printf("Это %s, он (она) говорит %s \n".formatted(a.getClass().getSimpleName(), a.sound()));
                            return a;
                        }));
    }
}
