package com.walking.lesson17_enum.task3;

public enum RegularShape {

    Square() {
        public void draw(int shapeLength) {
            for(int i = 0; i < shapeLength; ++i) {
                if (i != 0 && i != shapeLength - 1) {
                    System.out.println("|" + " ".repeat(shapeLength - 2) + "|");
                } else {
                    System.out.println(" " + "-".repeat(shapeLength - 2) + " ");
                }
            }

        }
    },
    Triangle() {
        public void draw(int shapeLength) {
            String s;
            int i;
            if (shapeLength % 2 == 0) {
                for(i = 0; i < shapeLength; ++i) {
                    if (i != shapeLength - 1) {
                        s = " ".repeat(shapeLength - 2 - i);
                        System.out.println(s + "/" + " ".repeat(i * 2) + "\\");
                    } else {
                        System.out.println("-".repeat(i * 2));
                    }
                }
            } else {
                for(i = 0; i < shapeLength; ++i) {
                    if (i != shapeLength - 1) {
                        s = " ".repeat(shapeLength - 2 - i);
                        System.out.println(s + "/" + " ".repeat(i * 2 + 1) + "\\");
                    } else {
                        System.out.println("-".repeat(i * 2 + 1));
                    }
                }
            }

        }
    };


    protected abstract void draw(int shapeLength);
}
