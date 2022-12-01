package com.walking.lesson16_abstract_class_interface.task1interface;

public class Square implements RegularShape {

    private int shapeLength;
    Square(int shapeLength) {
        setLength(shapeLength);
    }


    public void setLength(int shapeLength) {
        this.shapeLength = shapeLength;
    }
    public void draw() {
        for(int i = 0; i < this.shapeLength; ++i) {
            if (i != 0 && i != this.shapeLength - 1) {
                System.out.println("|" + " ".repeat(this.shapeLength - 2) + "|");
            } else {
                System.out.println(" " + "-".repeat(this.shapeLength - 2) + " ");
            }
        }

    }
}
