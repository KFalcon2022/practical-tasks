package com.walking.lesson14_polymorphism.task1;
    abstract class RegularFigure {
    protected static final int MINIMAL_DIMENSION = 2;
    abstract protected String draw(int sideLength);

}

interface Drawable{
    int MINIMAL_DIMENSION = 2;
    public String draw(int size);
}
