package com.walking.lesson16_abstract_class_interface.task1;

interface Drawable{
    void draw();
    
    static void drawLine(String string) {
        // Можно, конечно, накапливать строку вывода
        // И сделать, чтоб commit вернул готовый результат
        System.out.println(string);
    }
}