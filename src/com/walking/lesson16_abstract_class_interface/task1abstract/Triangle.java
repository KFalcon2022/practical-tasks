package com.walking.lesson16_abstract_class_interface.task1abstract;

public class Triangle extends RegularShape {
    Triangle(int shapeLength) {
        super(shapeLength);
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
