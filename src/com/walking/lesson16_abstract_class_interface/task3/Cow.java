package src.com.walking.lesson16_abstract_class_interface.task3;

public class Cow extends Animal {


    public Cow(String name, String color) {
        super(name,color);
        super.type = "Cow";
    }

    public String getSound(){

        String sound = "Cow says moo";

        return sound;
    }

}
