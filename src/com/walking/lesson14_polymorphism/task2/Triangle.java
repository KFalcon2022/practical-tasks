package com.walking.lesson14_polymorphism.task2;
public class Triangle extends rightShape {
    private static final String ECKE = "\\";
    protected static final String HORIZONTAL_LINE = "_";
    private List<String> triangleArray = new ArrayList();
    private final int width;

    public Triangle(int length, int width) {
        super(length);
        if (width >= 1 && width < Integer.MAX_VALUE) {
            this.width = width;
        } else {
            System.out.println("Wrong width");
            this.width = 1;
        }

    }

    public void draw() {
        this.triangleCalculate(this.length - 1, this.width - 1);
        Iterator var1 = this.triangleArray.iterator();

        while(var1.hasNext()) {
            String line = (String)var1.next();
            System.out.println(line);
        }

    }

    private List<String> triangleCalculate(int length, int width) {
        String line = "";
        int i;
        if (length == 0) {
            line = line + "|";

            for(i = 0; i <= width; ++i) {
                if (i != width) {
                    line = line + "_";
                } else {
                    line = line + "\\";
                }
            }

            this.triangleArray.add(line);
            return this.triangleArray;
        } else {
            if (length == this.length - 1) {
                line = line + "\\";

                for(i = 0; i <= width; ++i) {
                    line = line + " ";
                }

                this.triangleArray.add(line);
            } else {
                String sub1 = "|";
                if (this.length - length - 1 < width) {
                    sub1 = sub1 + " ".repeat(this.length - length - 1);
                } else {
                    sub1 = sub1 + " ".repeat(width - 1);
                }

                String sub2 = "\\";

                for(int i = 0; i <= width - 1; ++i) {
                    sub2 = sub2 + " ";
                }

                line = sub1 + sub2;
                this.triangleArray.add(line);
            }

            return this.triangleCalculate(length - 1, width);
        }
    }
}