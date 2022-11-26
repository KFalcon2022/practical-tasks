import java.util.Scanner;
public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Введи размер");


        int size= scanner.nextInt();

        System.out.println("Квадрат - 1, Треугольик -2");


        int type= scanner.nextInt();
if (type==2) {
    RightFigure Figure = new Triangle();
    Figure.print(size);
}
        if (type==1) {
            RightFigure Figure = new Sqare();
            Figure.print(size);
        }

    }
}