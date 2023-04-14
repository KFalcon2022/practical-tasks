package com.walking.lesson25_nested_classes.task2.anonymous_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson14_polymorphism/task2">...</a>
 * используя анонимные классы.
 */
public class Main {
    private static String userChoice;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("1.Cat \n2.Dog \n3.Cow \nChose animal: ");
        Main.userChoice = Main.validateChoice(reader.readLine());
        System.out.println(createAnimalByChoice());
    }
    private static String validateChoice(String userChoice)
    {
        if (!(userChoice.toLowerCase().contains("cat")
                || userChoice.toLowerCase().contains("cow")
                || userChoice.toLowerCase().contains("dog"))) {
            try {
                int choice = Integer.parseInt(userChoice);
                switch (choice) {
                    case 1:
                        userChoice = "cat";
                        break;
                    case 2:
                        userChoice = "dog";
                        break;
                    case 3:
                        userChoice = "cow";
                        break;
                    default:
                        throw new AnimalException(userChoice);
                }
            } catch (NumberFormatException e) {}
        }
        return userChoice;
    }

    private static Animal createAnimalByChoice() {
        Animal animal;
        if (userChoice.contains("cat") || Integer.parseInt(userChoice) == 1)
        {
            animal = new Animal(){
                @Override
                public String sound() {
                    return CAT_SOUND;
                }
                @Override
                public String toString()
                {
                    return sound();
                }
            };
        }
        else if (userChoice.contains("dog") || Integer.parseInt(userChoice) == 2)
        {
            animal = new Animal(){
                @Override
                public String sound() {
                    return DOG_SOUND;
                }
                @Override
                public String toString()
                {
                    return sound();
                }
            };
        }
        else {
            animal = new Animal(){
                @Override
                public String sound() {
                    return COW_SOUND;
                }
                @Override
                public String toString()
                {
                    return sound();
                }
            };
        }
        return animal;
    }