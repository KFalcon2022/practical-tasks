package src.com.walking.lesson16_abstract_class_interface.task3;

public class Cat extends Animal{



    public Cat(String name, String color) {
        super(name,color);
        super.type = "Cat";
    }

    public String getSound(){
        String sound = "Cat says meow";

        return sound;
    }

}
