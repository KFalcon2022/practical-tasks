package com.walking.lesson19_object_methods;

public enum Colors {
    BLACK(0, "BLACK"),
    WHITE(1, "WHITE"),
    RED(2, "RED"),
    GREEN(3, "GREEN"),
    BLUE(4, "BLUE");

    private int colorID;
    private String colorName;
    Colors (int coloID, String colorName) {
        this.colorID = coloID;
        this.colorName = colorName;
    }

    public int getColorID() {
        return colorID;
    }

    public String getColorName() {
        return colorName;
    }

    public static String getNameViaID(int ID) {
        for (Colors color : Colors.values()) {
            if (color.getColorID() == ID) return color.getColorName();
        }
        return null;
    }

}
