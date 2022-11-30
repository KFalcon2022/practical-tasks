package src.com.walking.lesson17_enum.task2;

public enum Animal {
    CAT("meow"), DOG("woof"), COW("moo");

    private String say;

    Animal(String say) {
        this.say = say;
    }

    public String getSay() {

        return say;
    }

    public static void saySomething(Animal... animals) {
        for (Animal i : animals) {
            System.out.print("Животное " + i.name() + " хочет сказать ");
            System.out.println(i.getSay());
        }
    }

}
