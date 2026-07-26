package com.walking.lesson14_polymorphism.task1.model;

public class RegularShape {

    // Длина стороны фигуры
    protected final int length;

    // Элемент для рисования горизонтальной линии
    protected final String horizontalLine;

    // Элемент для рисования левой вертикальной линии
    protected final String verticalLeftLine;

    // Элемент для рисования правой вертикальной линии
    protected final String verticalRightLine;

    // Пустой элемент рисования для всех дочерних классов одинаков
    protected static final String EMPTY_ELEMENT = " ";

    // Конструкторы для дочерних классов
    // Для разных вертикальных элементов (право/лево)
    protected RegularShape(int length,
                           String horizontalLine,
                           String verticalLeftLine,
                           String verticalRightLine){
        this.length = length;
        this.horizontalLine = horizontalLine;
        this.verticalLeftLine = verticalLeftLine;
        this.verticalRightLine = verticalRightLine;
    }

    // Для одинаковых вертикальных элементов справа и слева
    protected RegularShape(int length,
                           String horizontalLine,
                           String verticalLine){
        this(length, horizontalLine, verticalLine, verticalLine);
    }

    // Защищённый метод рисования фигуры
    protected void draw(){
        // Функционал будет переопределён в дочерних классах
    }

    // Публичный метод инициации рисования
    public void drawShape(){
        draw();
    }
}
