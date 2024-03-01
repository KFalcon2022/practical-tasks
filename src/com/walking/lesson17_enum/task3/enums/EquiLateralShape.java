package com.walking.lesson17_enum.task3.enums;

public enum EquiLateralShape {
    TRIANGLE{
        @Override
        public String drawFigure(int size){
            return "Устал вспоминать код отрисовки треугольника. Вот вам взамен куча сисек.\n" +
                    "(.)(.)   ".repeat(size);
        }
    },
    SQUARE{
        @Override
        public String drawFigure(int size) {
            StringBuilder draw = new StringBuilder();
            String fillingSymbol;

            for (int y = 0; y < size; y++){

                if (y == 0 || y == size - 1){fillingSymbol = HORIZONTAL;} //first or last line
                else {fillingSymbol = " ";}

                draw.append(VERTICAL); //first column

                for (int x = 1; x < size -1 ; x++){
                    draw.append(fillingSymbol);
                }

                draw.append(VERTICAL + "\n"); //last column
            }
            return draw.toString();
        }
    };
    final String HORIZONTAL = "-";
    final String VERTICAL = "|";
    final String TRIANGLE_LEFT_SIDE = "/";
    final String TRIANGLE_RIGHT_SIDE = "\\";
    public abstract String drawFigure(int size);
}
