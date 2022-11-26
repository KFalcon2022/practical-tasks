package lesson14.task1RightFigure;

public class Task1Square extends Task1RightFigure{
    //удваеваем символ для горизонтальной линии, чтобы выглядело нормально
    final String horizontalSymbol = "--";
    final String verticalSymbol = "|";
    //два пробела чтобы соответствовало горизонтальной линии
    final String insideSpaceSymbol = "  ";
    final String cornersSymbol = "*";

    public Task1Square(int length) {
        super(length, 4);
    }

    @Override
    public void draw() {
        String figurePrint = "";
        String horizontalLine = getHorizontalLine();
        String verticalLine = getVerticalLine();

        figurePrint += horizontalLine + "\n";
        for (int i = 0; i < length; i++) {
            figurePrint += verticalLine + "\n";
        }
        figurePrint += horizontalLine;

        System.out.println(figurePrint);
    }

    private String getHorizontalLine() {
        String horizontalLine = "";

        horizontalLine += cornersSymbol;
        for (int i = 0; i < length; i++) {
            horizontalLine += horizontalSymbol;
        }
        horizontalLine += cornersSymbol;

        return horizontalLine;
    }

    private String getVerticalLine() {
        String verticalLine = "";

        verticalLine += verticalSymbol;
        for (int j = 0; j < length; j++) {
            verticalLine += insideSpaceSymbol;
        }
        verticalLine += verticalSymbol;

        return verticalLine;
    }
}