package lesson10_static_constants.task1;

import java.util.Scanner;

/**
 * Используя кодовую базу из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson6_methods/Task3.java">...</a>
 * вынести строковые и символьные литералы в константы.
 * Попробуйте нарисовать прямоугольник, используя "==" для каждой единицы длины и
 * "||" – для каждой единицы ширины.
 * <p>
 * Также попробуйте записать в константу переменную scanner.
 * Упростится ли использование сканера внутри методов чтения с клавиатуры?
 */
public class Main {
    public static final String RECTANGLE_LENGTH_REQUIRE_MESSAGE = "Enter rectangle's length: ";
    public static final String RECTANGLE_WIDTH_REQUIRE_MESSAGE = "Enter rectangle's width: ";

    //    Увеличиваем количество угловый пробелов, поскольку вертикальная граница теперь занимает 2 символа
    public static final String RECTANGLE_EMPTY_ELEMENT = "  ";
    public static final String RECTANGLE_HORIZONTAL_ELEMENT = "==";
    public static final String RECTANGLE_VERTICAL_ELEMENT = "||";
    public static final String EMPTY_STRING = "";
    public static final char NEW_LINE_SYMBOL = '\n';

    public static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        int length = requireInt(RECTANGLE_LENGTH_REQUIRE_MESSAGE);
        int width = requireInt(RECTANGLE_WIDTH_REQUIRE_MESSAGE);
        SCANNER.close();

        String horizontalLine = createHorizontalLine(length);
        String verticalLines = createVerticalLines(length, width);

        printRectangle(horizontalLine, verticalLines);
    }

    static int requireInt(String requiringMessage) {
        System.out.print(requiringMessage);

        return SCANNER.nextInt();
    }

    static void printRectangle(String horizontalLine, String verticalLines) {
        System.out.print(horizontalLine + verticalLines + horizontalLine);
    }

    static String createHorizontalLine(int length) {
        String horizontalLine = RECTANGLE_EMPTY_ELEMENT;

        for (int i = 0; i < length; i++) {
            horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
        }

        horizontalLine += RECTANGLE_EMPTY_ELEMENT + NEW_LINE_SYMBOL;

        return horizontalLine;
    }

    static String createVerticalLines(int length, int width) {
        String verticalLinesUnit = getVerticalLinesUnit(length);

        String verticalLines = EMPTY_STRING;

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }

        return verticalLines;
    }

    static String getVerticalLinesUnit(int length) {
        String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += RECTANGLE_EMPTY_ELEMENT;
        }

        verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;

        return verticalLinesUnit;
    }
}
