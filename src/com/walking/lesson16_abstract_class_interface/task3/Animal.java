package src.com.walking.lesson16_abstract_class_interface.task3;

public abstract class Animal {

    protected String name;
    protected String type;
    protected String color;

    private Animal(){}

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract String getSound();

}
