import java.util.Scanner;

public class Counter { // создаем класс Счетчик
    String name; // поле Имя
    int counter; // поле счетчик

    public Counter(String name, int counter) { //создаем конструктор
        this.name = name; // с полем Имя
        this.counter = counter; // и полем Счетчик
    }


    public void incrimentOne(){ //метод увеличение на 1
        counter = counter + 1; //к значению счетчика прибавляем 1
        System.out.println("Новое значение счетчика " + counter); //на экран выводим новое значение
    }

    public void decrimentOne () {//метод уменьшение на 1
        counter = counter - 1;//от значения счетчика убавляем 1
        System.out.println("Новое значение счетчика " + counter);//на экран выводим новое значение
    }

    public void incrimentAny(){//метод увеличение на любое число
        Scanner sc = new Scanner(System.in); //подключаем сканер
        System.out.println("Введите число, на которое будет увеличено значение счетчика: ");
        int a = sc.nextInt(); //введенному числу присваиваем как переменная а
        sc.close(); //закрываем сканер

        counter = counter + a; //прибавляем к значению счетчика введенное число
        System.out.println("Новое значение счетчника " + counter);
    }

    public void decrimentAny(){//метод уменьшение на любое число
        Scanner sc = new Scanner(System.in);//подключаем сканер
        System.out.println("Введите любое число, на которое будет уменьшено значение счетчика:  ");
        int a = sc.nextInt();//введенному числу присваиваем как переменная а
        sc.close();//закрываем сканер

        counter = counter - a;//убавляем от значения счетчика введенное число
        System.out.println("Новое значение счетчника " + counter);
    }
}
