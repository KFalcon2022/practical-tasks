package com.walking.lesson27_generics.task4;

import com.walking.lesson19_object_methods.model.Car;
import com.walking.lesson27_generics.task4.linked_list_stack.MyLinkedListStack;
import com.walking.lesson27_generics.task4.my_stack.MyStack;

public class Main {
    public static void main(String[] args) {
        MyStack<String> myStackOfStrings = new MyStack<>(String.class, 16);
        MyStack<Car> myStackOfCars = new MyStack<>(Car.class, 16);

        fillStringStack(myStackOfStrings);
        myStackOfStrings.deleteElement();
        myStackOfStrings.deleteElement();
        myStackOfStrings.deleteElement("5");

        fillCarStack(myStackOfCars);

        System.out.println(myStackOfStrings);

        System.out.println(myStackOfCars);

        MyLinkedListStack<String> stringMyLinkedListStack = new MyLinkedListStack<>();

        MyLinkedListStack<Car> myLinkedListStackOfCars = new MyLinkedListStack<>();

        fillStringStack(stringMyLinkedListStack);
        fillCarStack(myLinkedListStackOfCars);

        stringMyLinkedListStack.deleteGivenElement("2");
        stringMyLinkedListStack.deleteGivenElement("3");

        System.out.println(stringMyLinkedListStack);
        System.out.println(myLinkedListStackOfCars);
    }

    // Только для внутреннего пользования)
    private static void fillStringStack(MyStack<String> myStack) {
        for (int i = 0; i < 20; i++) {
            myStack.addElement(String.valueOf(i));
        }
    }
    // Только для внутреннего пользования)
    private static void fillCarStack(MyStack<Car> myStack) {
        for (int i = 0; i < 20; i++) {
            myStack.addElement(new Car(String.valueOf(i), String.format("Brand %d", i), "Engine"));
        }
    }
    // Только для внутреннего пользования)
    private static void fillStringStack(MyLinkedListStack<String> myStack) {
        for (int i = 0; i < 20; i++) {
            myStack.addElement(String.valueOf(i));
        }
    }
    // Только для внутреннего пользования)
    private static void fillCarStack(MyLinkedListStack<Car> myStack) {
        for (int i = 0; i < 20; i++) {
            myStack.addElement(new Car(String.valueOf(i), String.format("Brand %d", i), "Engine"));
        }
    }
}
