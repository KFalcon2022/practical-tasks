package com.walking.lesson16_abstract_class_interface.task1abstract;

public class Square extends RegularShape {
    Square(int shapeLength) {
        super(shapeLength);
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
