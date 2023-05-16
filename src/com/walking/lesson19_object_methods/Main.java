package com.walking.lesson19_object_methods;

/**
 * Реализуйте класс «Машина». Поля допустимо выбрать на свое усмотрение, но необходимо,
 * чтобы по ним можно было однозначно идентифицировать каждую машину.
 * Скажем, в рамках базы ГАИ.
 * <p>
 * Создайте массив машин. Реализуйте максимально эффективную проверку на вхождение машины в ваш массив.
 * Данные для проверки необходимо запрашивать с клавиатуры.
 * <p>
 * Если машина найдена — выведите ее строковое представление в консоль.
 * <p>
 * Опциональное усложнение: номер машины может быть не уникальным.
 */
import com.walking.lesson19_object_methods.model.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Car cars[]= new Car[]{new Car("123av","a"),new Car("456ay","b"), new Car("123av", "c")};

        System.out.print("car number:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        System.out.print("car model:");
        String model = scanner.next();

        Car searchCar = new Car(number,model);
        boolean found=false;
        for (Car car:cars){
            if (car.equals(searchCar)){
                System.out.println("car found");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("car not found");
        }
    }
}
