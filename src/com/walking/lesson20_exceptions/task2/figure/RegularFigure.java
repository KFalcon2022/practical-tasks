package com.walking.lesson20_exceptions.task2.figure;

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
