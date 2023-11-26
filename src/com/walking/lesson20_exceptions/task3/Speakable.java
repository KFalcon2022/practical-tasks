package Lesson20.Task3;

public interface Speakable {
    static void getSound(Object obj)
    {
        if (obj.getClass().equals(Cat.class))
            ((Cat)obj).getSound();
        if (obj.getClass().equals(Dog.class))
            ((Dog)obj).getSound();
        if (obj.getClass().equals(Cow.class))
            ((Cow)obj).getSound();
        if ((!(obj.getClass().equals(Cat.class))) && (!(obj.getClass().equals(Dog.class))) && (!(obj.getClass().equals(Cow.class))))
            throw new UnknownAnimalException("Unknown animal", obj);
    }
}
