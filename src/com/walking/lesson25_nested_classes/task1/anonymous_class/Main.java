package com.walking.lesson25_nested_classes.task1.anonymous_class;

import java.util.Scanner;

import com.walking.lesson25_nested_classes.task1.anonymous_class.model.CorrectFigure;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson16_abstract_class_interface/task1_interface">...</a>
 * используя анонимные классы.
 */
public class Main {
    public static void main(String[] args) {
        Integer type;
        Integer length;
        Scanner sc=new Scanner(System.in);

        System.out.println("Insert figure: 1-triangle, 2-square :");
        type=sc.nextInt();
        System.out.println("Insert length");
        length=sc.nextInt();
        sc.close();

        System.out.println(printFigure(type, length));

    }
    private static String printFigure(Integer type, Integer length){
        CorrectFigure figure;
        if (type==1){
            figure=new CorrectFigure(){
                @Override
                public String printFigure() {
                    String triangle="";
                    for (int i=1; i<=getLength(); i++){
                        if (i==1){
                            triangle+=repeatString(SPACE, getLength()-i)+LEFT_LINE+RIGHT_LINE+NEW_LINE;
                        } else if(i==getLength()) {
                            triangle+=LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                            triangle+=repeatString(HORIZONTAL_LINE, getLength()*2)+NEW_LINE;
                        } else {
                            triangle+=repeatString(SPACE, getLength()-i)+LEFT_LINE+repeatString(SPACE, (i-1)*2)+RIGHT_LINE+NEW_LINE;
                        }
                    }
                    return triangle;
                }

                @Override
                public int getLength() {
                    return length;
                }
            };  
        } else{
            if(type==2){
                figure=new CorrectFigure() {
                    @Override
                    public int getLength() {
                        return length;
                    }

                    @Override
                    public String printFigure() {
                        String square="";
                        for (int i=1; i<=getLength(); i++){
                            if (i==1){
                                square+=SPACE+repeatString(HORIZONTAL_LINE, getLength()*2)+NEW_LINE;
                                square+=VERTICAL_LINE+repeatString(SPACE, getLength()*2)+VERTICAL_LINE+NEW_LINE;
                            } else if (i==getLength()){
                                square+=VERTICAL_LINE+repeatString(SPACE, getLength()*2)+VERTICAL_LINE+NEW_LINE;
                                square+=SPACE+repeatString(HORIZONTAL_LINE, getLength()*2)+NEW_LINE;
                            } else {
                                square+=VERTICAL_LINE+repeatString(SPACE, getLength()*2)+VERTICAL_LINE+NEW_LINE;
                            }
                        }
                        return square;
                    }
                    
                };
            } else {
                figure=null;
            }           
        }
        if (figure!=null){
            return figure.printFigure();
        } else {return "Empty";}
    }
}
