package com.walking.lesson16_abstract_class_interface.task1_abstract_class.model;

public class Triangle extends Figure{

    public Triangle(int width){
        super(width);
    }

    @Override
    public String builtFigure() {
        StringBuilder stringToDraw = new StringBuilder();
        StringBuilder sideSpaces = new StringBuilder();  //пробелы снаружи треугольника
        StringBuilder innerSpaces = new StringBuilder(); //пробелы внутри треугольника
        byte spaceCount = (byte) ((width-2) / 2);        //Узнаем сколько нам нужно пробелов сбоку
        byte innerSpaceCount = 0;                        //в первой строке треугольника нет внутренних пробелов


//отрисовываем треугольник по строкам сверху вниз
        for (byte y = spaceCount; y >= 0; y--) {
            for (byte x = 0; x <= y; x++) {
                sideSpaces.append(FILLING_SYMBOL);
            }

//символы боковых сторон треугольника и пробелы (или черту в самой нижней строке) между ними
            for (byte x = 0; x < innerSpaceCount; x++) {
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

            sideSpaces = new StringBuilder(); //обнуляем переменные перед следующей итерацией цикла
            innerSpaces = new StringBuilder();

            innerSpaceCount += 2; //в следующей строке внутри треугольника будет на 2 пробела больше
        }

        return stringToDraw.toString();
    }


}
