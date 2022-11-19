package lesson4_cycles;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rectangle's length: ");
        int length = scanner.nextInt();

        System.out.print("Enter rectangle's width: ");
        int width = scanner.nextInt();

        scanner.close();

        String horizontalLine = " ";

        for (int i = 0; i < length; i++) {
            horizontalLine += "-";
        }

        horizontalLine += " \n";

        String verticalLinesUnit = "|";

        for (int i = 0; i < length; i++) {
            verticalLinesUnit += " ";
        }

        verticalLinesUnit += "|\n";

        String verticalLines = "";

        for (int i = 0; i < width; i++) {
            verticalLines += verticalLinesUnit;
        }

        System.out.println(horizontalLine + verticalLines + horizontalLine);
    }
}
