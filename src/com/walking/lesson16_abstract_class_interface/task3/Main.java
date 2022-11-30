package src.com.walking.lesson16_abstract_class_interface.task3;
import src.com.walking.lesson16_abstract_class_interface.task3.Animal;
import src.com.walking.lesson16_abstract_class_interface.task3.Cat;
import src.com.walking.lesson16_abstract_class_interface.task3.Cow;
import src.com.walking.lesson16_abstract_class_interface.task3.Dog;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Barsik","blue");
        animals[1] = new Dog("Zhuchka","red");
        animals[2] = new Cow("Marusya", "white");

        //статический метод в Мейн, обходим запросы instanceof + getClass и тд
        showAnimal(animals);

        //второй метод покажет тип животного, значение передается в суперкласс при создании, можно использовать для поиска по типу
        showType(animals);

    }

    static void showAnimal(Animal... animals) {
        System.out.println("Наши животные что говорят? ");
        for (Animal i : animals) {
            System.out.println(i.getSound());
        }
    }

    static void showType(Animal... animals){
        System.out.println("Посмотрим какие животные были у нас? ");
        for (Animal i : animals) {
            System.out.println(i.type);
        }
    }
}
