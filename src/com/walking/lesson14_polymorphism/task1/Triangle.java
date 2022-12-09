package com.walking.lesson14_polymorphism.task1;

public class Triangle extends Figure {
    
    private final String SPACE = " ";
    private final String LEFT = "/";
    private final String RIGHT = "\\";
    private final String BOTTOM = "_";
    private final String CORNER = ".";
    
    public Triangle(int sideSize) {
        super(3, sideSize);
    }

    public void draw() {
        for (int i=0; i<this.sideSize; i++){
            for (int j=i; j<this.sideSize; j++){
                System.out.print(SPACE);
            }
            
            System.out.print(LEFT);

            for (int j=0; j<i*2; j++){
                System.out.print(SPACE);
            }
            
            System.out.print(RIGHT + NEWLINE);
        }
        
        this.drawLine(CORNER, BOTTOM+BOTTOM, CORNER);
    }

}
