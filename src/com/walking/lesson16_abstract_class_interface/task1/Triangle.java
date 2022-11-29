package com.walking.lesson16_abstract_class_interface.task1;

public class Triangle extends Figure {

    private final String SPACE = " ";
    private final String LEFT = "/";
    private final String RIGHT = "\\";
    private final String BOTTOM = "__";
    private final String CORNER = ".";

    public Triangle(int sideSize) {
        super(3, sideSize);
    }

    public void draw() {
        for (int i=0; i<this.sideSize; i++){
            String string = "";
            
            for (int j=i; j<this.sideSize; j++){
                string += SPACE;
            }

            string += LEFT;

            for (int j=0; j<i*2; j++){
                string += SPACE;
            }

            string += RIGHT;
            
            this.print(string);
        }

        this.print(CORNER, BOTTOM, CORNER);
    }

}