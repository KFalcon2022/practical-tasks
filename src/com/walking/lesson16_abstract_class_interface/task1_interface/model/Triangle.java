package com.walking.lesson16_abstract_class_interface.task1_interface.model;

public class Triangle implements Figure{

    @Override
    public String drawFigure(int width) {
        StringBuilder stringToDraw = new StringBuilder();
        StringBuilder sideSpaces = new StringBuilder();  //пробелы снаружи треугольника
        StringBuilder innerSpaces = new StringBuilder(); //пробелы внутри треугольника
        int spaceCount = (width-2) / 2;                  //Узнаем сколько нам нужно пробелов сбоку
        int innerSpaceCount = 0;                         //в первой строке треугольника нет внутренних пробелов


//отрисовываем треугольник по строкам сверху вниз
        for (int y = spaceCount; y >= 0; y--) {
            sideSpaces.append(FILLING_SYMBOL.repeat(Math.max(0, y + 1)));

//символы боковых сторон треугольника и пробелы (или черту в самой нижней строке) между ними
            for (int x = 0; x < innerSpaceCount; x++) {
                if (y != 0) innerSpaces.append(FILLING_SYMBOL);  //если не последняя строка, то наполняем пробелами
                else innerSpaces.append(HORIZONTAL_SYMBOL);      //если последняя - то это основание треугольника
            }

/* строка треугольника состоит из:
 * пробелы слева + левая грань + пробелы между гранями + правая грань + пробелы справа
 *    /\
 *   /  \
 *  /----\
 *
 */

            stringToDraw.append
                    (sideSpaces).append
                    (TRIANGLE_LEFT_SYMBOL).append
                    (innerSpaces).append
                    (TRIANGLE_RIGHT_SYMBOL).append
                    (sideSpaces).append("\n");

            sideSpaces = new StringBuilder();
            innerSpaces = new StringBuilder();
            innerSpaceCount += 2; //в следующей строке внутри треугольника будет на 2 пробела больше
        }

        return stringToDraw.toString();
    }
}
