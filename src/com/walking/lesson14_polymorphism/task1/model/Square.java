package com.walking.lesson14_polymorphism.task1.model;

public class Square extends RegularShape{

    public Square(int length){
        super(length, "---", "|");
    }

    @Override
    protected void draw(){

        // Для квадрата можно сформировать всего две строки:
        // горизонтальную линию из "---" для верхней и нижней границы фигуры
        // и горизонтальную линию с вертикальными элементами "|" по краям
        String topBottom = getRowLine(this.length, EMPTY_ELEMENT, this.horizontalLine);
        String middle = getRowLine(this.length, this.verticalLeftLine, EMPTY_ELEMENT.repeat(3)); // Пустой элемент х3 для "квадратности"

        // Выводим первую строку рисования прямоугольника
        System.out.println(topBottom);

        // Выводим все строки кроме первой и последней
        for(int i = 0; i < this.length; i++){
            System.out.println(middle);
        }

        // Выводим последнюю строку рисования прямоугольника
        System.out.println(topBottom);
    }

    //********************************************************************************//
    // Метод формирует строку заданной длины из указанных элементов для краёв и середины
    // Входные параметры:
    // - length (длина), тип - int
    // - edge (строка для краёв), тип - String
    // - center (строка для центральной части), тип - String
    // Возвращаемое значение:
    // - Строка, составленная из входящих элементов, тип - String
    //********************************************************************************//
    private String getRowLine(int length, String edge, String center){

        // Вместо String используем StringBuilder для оптимизации конкатенации строк
        StringBuilder strRow = new StringBuilder();

        // Первым и последним элементом точно будут края (edge)
        // Оставшееся заполняем повторением присоединения центральной части (center)
        strRow.append(edge);
        strRow.repeat(center, length);
        strRow.append(edge);

        return strRow.toString();
    }
}
