package com.walking.lesson20_exceptions.task3;

import com.walking.lesson18_instanceof_getClass.model.Animal;
import com.walking.lesson18_instanceof_getClass.model.Cat;
import com.walking.lesson18_instanceof_getClass.model.Cow;
import com.walking.lesson18_instanceof_getClass.model.Dog;
import com.walking.lesson20_exceptions.task3.Exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.Exception.UnknownAnimalException;

/**
 * Реализуйте любой из вариантов задачи в уроке 18.
 * Для ситуации, когда тип животного неизвестен, выбрасывайте собственное исключение UnknownAnimalException.
 * Предка исключения определите самостоятельно.
 * <p>
 * Также предусмотрите валидацию массива животных на содержание пустых элементов.
 * Если таковые существуют – бросьте кастомное исключение ArrayValidationException,
 * которое содержит информацию об индексе массива, содержащем null.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals=new Animal[6];
        animals[0]=new Cat();
        animals[1]=new Cow();
        animals[2]=new Cow();
        animals[3]=new Dog();
        animals[4]=new Dog();
        //animals[5]=new Cat();
        checkAnimals(animals);
    }
    public static void checkAnimals(Animal[] animals){
        Object o;
        for (int i=0; i<=animals.length-1; i++){
            o=animals[i];
            if (o==null) throw new ArrayValidationException(i);
            if (!(o instanceof Cat)&!(o instanceof Dog)&!(o instanceof Cow)) throw new UnknownAnimalException();
            if (o instanceof Cat) ((Cat)o).Meow();
            if (o instanceof Dog) ((Dog)o).Woof();
            if (o instanceof Cow) ((Cow)o).Moo();
        }
    }
}
