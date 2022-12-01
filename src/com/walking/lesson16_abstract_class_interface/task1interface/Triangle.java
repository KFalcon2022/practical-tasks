package com.walking.lesson16_abstract_class_interface.task1interface;

public class Triangle implements RegularShape {

    private int shapeLength;
    Triangle(int shapeLength) {
        setLength(shapeLength);
    }
    public void setLength(int shapeLength) {
        this.shapeLength = shapeLength;
    }
    public void draw() {
        String s;
        int i;
        if (this.shapeLength % 2 == 0) {
            for(i = 0; i < this.shapeLength; ++i) {
                if (i != this.shapeLength - 1) {
                    s = " ".repeat(this.shapeLength - 2 - i);
                    System.out.println(s + "/" + " ".repeat(i * 2) + "\\");
                } else {
                    System.out.println("-".repeat(i * 2));
                }
            }
        } else {
            for(i = 0; i < this.shapeLength; ++i) {
                if (i != this.shapeLength - 1) {
                    s = " ".repeat(this.shapeLength - 2 - i);
                    System.out.println(s + "/" + " ".repeat(i * 2 + 1) + "\\");
                } else {
                    System.out.println("-".repeat(i * 2 + 1));
                }
            }
        }

    }
}
