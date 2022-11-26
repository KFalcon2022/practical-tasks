package lesson14_polymorphism.task1;

class Square extends Shape {
    //бесполезное
    //final int SIZE = 4;

    Square (int length) {
        super(length);
    }

    @Override
    void draw() {
        int width = length + 2;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == width - 1) {
                    if (j == 0 || j == width - 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("-");
                    }
                } else if (j == 0 || j == width - 1) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
