package com.walking.lesson17_enum.task3.enums;

public enum EquiLateralShape {
    TRIANGLE{
        @Override
        public String drawFigure(int size){
            StringBuilder stringToDraw = new StringBuilder();
            StringBuilder sideSpaces = new StringBuilder();  //пробелы снаружи треугольника
            StringBuilder innerSpaces = new StringBuilder(); //пробелы внутри треугольника

            int sideSpaceCount = (size - 2) / 2; // Узнаем сколько нам нужно пробелов сбоку
            int innerSpaceCount = 0; //в первой строке треугольника нет внутренних пробелов


//отрисовываем треугольник по строкам сверху вниз
            for (int y = sideSpaceCount; y >= 0; y--) {
                sideSpaces.append(SPACE_SYMBOL.repeat(Math.max(0, y + 1))); //пробелы в строке снаружи стреуголника

//стороны боковых сторон треугольника и пробелы (или черту в самой нижней строке) между ними
                for (int x = 0; x < innerSpaceCount; x++) {
                    if (y != 0) innerSpaces.append(SPACE_SYMBOL); //если не последняя строка, то наполняем пробелами
                    else innerSpaces.append(HORIZONTAL_SYMBOL);   //если последняя - то это основание треугольника
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
    },
    SQUARE{
        @Override
        public String drawFigure(int size) {
            StringBuilder stringToDraw = new StringBuilder();
            String fillingSymbol;

            for (int y = 0; y < size; y++){

                if (y == 0 || y == size - 1) fillingSymbol = HORIZONTAL_SYMBOL; //first or last line
                else fillingSymbol = SPACE_SYMBOL;

                stringToDraw.append(VERTICAL_SYMBOL); //first column

                stringToDraw.append(fillingSymbol.repeat(Math.max(0, size - 2)));

                stringToDraw.append(VERTICAL_SYMBOL + "\n"); //last column
            }
            return stringToDraw.toString();
        }
    };
    final String HORIZONTAL_SYMBOL = "-";
    final String VERTICAL_SYMBOL = "|";
    final String SPACE_SYMBOL = " ";
    final String TRIANGLE_LEFT_SYMBOL = "/";
    final String TRIANGLE_RIGHT_SYMBOL = "\\";
    public abstract String drawFigure(int size);
}
