package Lesson16.Task1.interfaces;

public interface drowable {
    String HORIZONTAL_LINE = "-";
    String VERTICAL_LINE = "|";
    String EMPTY_ELEMENT = " ";
    String ENTER_NEW_LINE = "\n";
    String ECKE = "\\";
    String HORIZONTAL_UNDERLINE = "_";
    default void draw()
    {
        System.out.println("Unknown shape");
    }
}
