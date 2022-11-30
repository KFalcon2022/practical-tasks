package src.com.walking.lesson16_abstract_class_interface.task3;

public class Dog extends Animal {




    public Dog(String name, String color) {
        super(name,color);
        super.type = "Dog";
    }

    public String getSound(){
        String sound = "Dog says woof";

        return sound;
    }


}
