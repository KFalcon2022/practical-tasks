package com.walking.lesson25_nested_classes.task1.anonymous_class;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    private static String userChoice;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("1.Triangle \n2.Square \n Chose shape: ");
        Main.userChoice = Main.validateChoice(reader.readLine());
        System.out.print("Enter length: ");
        System.out.println(createShapeByChoice(Integer.parseInt(reader.readLine())));
    }
    private static String validateChoice(String userChoice)
    {
        if (!(userChoice.contains("tria")
                || userChoice.contains("squ")
                || (Integer.parseInt(userChoice) == 1 || Integer.parseInt(userChoice) == 2)))
        {
            try {
                int choice = Integer.parseInt(userChoice);
                switch (choice) {
                    case 1:
                        userChoice = "tria";
                        break;
                    case 2:
                        userChoice = "squ";
                        break;
                    default:
                        throw new ShapeException(userChoice);
                }
            } catch (NumberFormatException e) {}
    }
        return userChoice;
    }

    private static EquilShape createShapeByChoice(int length) {
        EquilShape shape;
        if (userChoice.contains("tria"))
        {
            return shape = new EquilShape(length)
            {
                @Override
                public String drawShape()
                {
                    return CreateStringShape();
                }
                private String CreateStringShape()
                {
                    String triangleString = "";
                    for (int i = 0; i<length; i++)
                    {
                        triangleString += EMPTY_ELEMENT.repeat((Math.round((float) length-i)/2))
                                + LEFT_ANGLE
                                + EMPTY_ELEMENT.repeat(i)
                                + RIGHT_ANGLE
                                + EMPTY_ELEMENT.repeat((Math.round((float) length-i)/2)) + ENTER_NEW_LINE;
                    }
                    triangleString += HORIZONTAL_UNDERLINE.repeat(length);
                    return triangleString;
                }

                @Override
                public String toString()
                {
                    return drawShape();
                }
            };
        }
        return shape = new EquilShape(length)
        {
            @Override
            public String drawShape()
            {
                return CreateStringShape();
            }
            private String CreateStringShape()
            {
                String squareString = "";
                squareString += HORIZONTAL_LINE.repeat(length) + ENTER_NEW_LINE;
                for (int i = 0; i < length-2; i++)
                {
                    squareString += VERTICAL_LINE + EMPTY_ELEMENT.repeat(length-2) + VERTICAL_LINE + ENTER_NEW_LINE;
                }
                squareString += HORIZONTAL_LINE.repeat(length) + ENTER_NEW_LINE;
                return squareString;
            }
            @Override
            public String toString()
            {
                return drawShape();
            }
        };
    }
}
