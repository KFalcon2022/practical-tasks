package com.walking.lesson14_polymorphism.task2;
public class Square extends rightShape {
    private static String widthLine = "";
    private static String lengthLine = "";

    public Square(int length) {
        super(length);
    }

    public final void draw() {
        if (this.length >= 0) {
            System.out.println(this.heightFiller());
            System.out.println(this.StringCalculator(this.length));
            System.out.println(this.heightFiller());
        }

    }

    private String StringCalculator(int length) {
        int lengthCalculate;
        if (length > 2) {
            lengthCalculate = length - 2;
        } else {
            lengthCalculate = length - 1;
        }

        return this.lengthFiller(lengthCalculate);
    }

    private String heightFiller() {
        String widthLine = "";
        if (this.length > 0) {
            for(int i = 0; i < this.length; ++i) {
                widthLine = widthLine + "-";
            }
        } else {
            System.out.println("Width error");
        }

        return widthLine;
    }

    private String lengthFiller(int lengthCounter) {
        if (lengthCounter == 0) {
            return lengthLine;
        } else {
            for(int i = 0; i < this.length; ++i) {
                if (i != this.length - 1 && i != 0) {
                    lengthLine = lengthLine + " ";
                } else {
                    lengthLine = lengthLine + "|";
                }
            }

            if (lengthCounter != 1) {
                lengthLine = lengthLine + "\n";
            }

            return this.lengthFiller(lengthCounter - 1);
        }
    }
}