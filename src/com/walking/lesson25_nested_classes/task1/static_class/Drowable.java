package Lesson25.Task1.StaticInner;

public interface Drowable {
    String HORIZONTAL_LINE = "-";
    String VERTICAL_LINE = "|";
    String EMPTY_ELEMENT = " ";
    String ENTER_NEW_LINE = "\n";
    String RIGHT_ANGLE = "\\";
    String LEFT_ANGLE = "/";
    String HORIZONTAL_UNDERLINE = "_";
    int getLength();

    static String drawShape(int l) {
        return "No such shape";
    }
}
