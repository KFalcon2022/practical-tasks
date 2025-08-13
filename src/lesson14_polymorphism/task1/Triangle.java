package lesson14_polymorphism.task1;

class Triangle extends Shape {
    //бесполезное
    //final int SIZE = 3;

    Triangle (int length) {
        super(length);
    }

    @Override
    void draw() {
        int spaces = 0;
        String betweener = " ";
        for (int i = length-1; i >= 0; i--) {
            if (i == 0) {
                betweener = "_";
            }
            String line = " ".repeat(i) + "/" + betweener.repeat(spaces) + "\\" + " ".repeat(i);
            System.out.println(line);
            spaces += 2;
        }
    }
}
