package Lesson17.Task2;

public class Animal {
    public Animal(String name)
    {
        switch (name.toLowerCase())
        {
            case "cat":
                WalkingAnimal.CAT.getSound();
                break;
            case "cow":
                WalkingAnimal.COW.getSound();
                break;
            case "dog":
                WalkingAnimal.DOG.getSound();
        }

    }
    enum WalkingAnimal {
        CAT
                {
                    @Override
                    public void getSound() {
                        System.out.println("meow");
                    }
                },
        COW
                {
                    @Override
                    public void getSound() {
                        System.out.println("moo");
                    }
                },
        DOG
                {
                    @Override
                    public void getSound() {
                        System.out.println("woof");
                    }
                };

        public void getSound()
        {
            System.out.println("...");
        }
    }
}
