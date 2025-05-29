package com.walking.lesson16_abstract_class_interface.task1_abstract_class.figures;

public abstract class RegularFigure {
    protected final String SPACE = " ";
    protected final String NEXT_LINE_SYMBOL = "\n";
    private final int length;

    protected RegularFigure(int length) {
        this.length = length;
    }

    public abstract String getFigure();

    public int getLength() {
        return length;
    }
}
