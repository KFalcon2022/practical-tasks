package com.walking.lesson16_abstract_class_interface.task1;

// В данном случае абстрактность ограничивается невозможностью создать просто фигуру
public abstract class Figure implements Drawable {

    public final int sides;
    public final int sideSize;
    public final static int[] available = new int[10];

    public Figure(int sides, int sideSize) {
        this.sides = sides;
        this.sideSize = sideSize;
    }

    // public abstract void draw(); // указано в интерфейсе
    
    // Вывод строки
    public void print(String string) {
        Drawable.drawLine(string);
    }

    // Перегрузка для вывода строки с границами
    public void print(String start, String middle, String end) {
        String string = start;
        for (int i = 0; i < this.sideSize; i++){
            string += middle;
        }
        string += end;
        Drawable.drawLine(string);
    }
}