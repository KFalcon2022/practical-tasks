package com.walking.lesson14_polymorphism.task1.model;

public class Triangle extends RegularShape {

    public Triangle(int length) {
        // Для горизонтальной линии использую "_" в последней строке (так фигура в целом больше похоже на треугольник)
        super(length, "_", "/", "\\");
    }

    @Override
    protected void draw() {

        // Количество выводимых строк при рисовании равно длине стороны.
        // Для первой строки рисуем левую и правую вертикальные линии в позициях "длина" и "длина + 1" соответственно.
        // Для каждой последующей строки уменьшаем позицию левой линии на единицу и увеличиваем для правой линии.
        // Остальные позиции заполняем единичными пробелами.
        // Для последней строки цикла выводим нижнюю горизонтальную линию по количеству элементов как длина * 2

        for (int i = 1; i <= this.length; i++){
            // Рисуем строку, где левая вертикальная линия = length + 1 - i, а правая length + i
            drawLine(this.length + 1 - i, this.length + i);
        }
    }

    //********************************************************************************//
    // Метод "рисует" линию для треугольника
    // Входные параметры:
    // - leftElement (позиция левого вертикального элемента в строке), тип - int
    // - rightElement (позиция правого вертикального элемента в строке), тип - int
    // Возвращаемое значение:
    // - отсутствует, тип - void
    //********************************************************************************//
    private void drawLine(int leftElement, int rightElement){

        // Вместо String используем StringBuilder для оптимизации конкатенации строк
        StringBuilder strRow = new StringBuilder();

        for(int i = 1; i <= this.length * 2; i++){
            if(i == leftElement){ // итерация цикла совпала с индексом левого элемента
                strRow.append(this.verticalLeftLine);
            } else if (i == rightElement) { // итерация цикла совпала с индексом правого элемента
                strRow.append(this.verticalRightLine);
            }
            else if (this.length * 2 == rightElement) { // Добрались до рисования последней строки треугольника
                strRow.append(this.horizontalLine);
            }
            else
                strRow.append(EMPTY_ELEMENT); // рисуем пустые элементы
        }
        System.out.println(strRow);
    }
}
