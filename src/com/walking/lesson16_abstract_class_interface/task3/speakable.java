package Lesson16.Task3;

public interface speakable {
    String sound = "...";
    default void sound()
    {
        System.out.println(sound);
    }
    private static void speak()
    {
        System.out.println(sound);
    }
    static void sound (String animal)
    {
        if (animal.equals("Cat"))
        System.out.println("meow");
        else if (animal.equals("Dog"))
        System.out.println("woof");
        else if (animal.equals("Cow"))
            System.out.println("moo");
        else speak();
    }
    static void sound (String animal, String name)
    {
        if (animal.equals("Cat"))
            System.out.println(name +" says: meow");
        else if (animal.equals("Dog"))
            System.out.println(name +" says: woof");
        else if (animal.equals("Cow"))
            System.out.println(name +" says: moo");
        else speak();
    }
}
