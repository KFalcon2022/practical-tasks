package com.walking.lesson16_abstract_class_interface.task3;

public class Main {

    private static String S_SAY_PATTERN = "%s says %s\n";
    
    public static void main(String[] args) {
        
        Animal[] animals = {
            new Cat("Vasya", 5),
            new Dog("Sharik", 6),
            new Cat("Musya", 3),
            new Turtle("Mike", 100),
            new Cow("Nochka", 3)
        };
        
        for (Animal animal: animals){
            System.out.print(String.format(S_SAY_PATTERN, animal.getInfo(), animal.talk()));
        }
    }
}
