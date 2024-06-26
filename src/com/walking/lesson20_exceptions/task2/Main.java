package com.walking.lesson20_exceptions.task2;

import java.util.Scanner;

import com.walking.lesson16_abstract_class_interface.task1_interface.model.CorrectFigure;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Square;
import com.walking.lesson16_abstract_class_interface.task1_interface.model.Triangle;
import com.walking.lesson20_exceptions.task2.Exception.InputValidationException;
import com.walking.lesson20_exceptions.task2.Exception.InputValidationException.Reason;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 */
public class Main {
        public static void main(String[] args) {
        CorrectFigure figure=null;
        System.out.print("Insert figure: 1-triangle, 2-square :");
        Scanner sc=new Scanner(System.in);
        int figureType=sc.nextInt();
        System.out.print("Insert length:");
        int length=sc.nextInt();
        sc.close();
        if (validateInput(figureType, length)){
            switch (figureType) {
                case 1:
                    figure=new Triangle(length);
                    break;
                case 2:
                    figure=new Square(length);
                break;
            }
        }
        if (figure!=null)
        System.out.print(figure.printFigure());
    }

    private static boolean validateInput(int type, int length){
        if (type!=1&type!=2){
            throw new InputValidationException(Reason.WrongType);
        }
        if (length<=1){
            throw new InputValidationException(Reason.WrongLength);
        }
        return true;
    }
}


