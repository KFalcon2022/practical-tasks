package com.walking.lesson28.Task4;

public class Main {
    public static void main(String[] args) {
        runStringTest();
        runIntTest();
    }

    private static void runStringTest(){
        System.out.println("\nSTACK OF STRINGS");

        Stack stack = new Stack<String>(String.class, 100);
        stack.push("1")
            .push("asd hjakjqwe")
            .push("poi2134gd")
            .push("Hahahaha");

        String popValue = (String) stack.pop();
        System.out.println("Popped value = " + popValue);

        stack.push("w43tegrdnbg")
            .push("One more");

        System.out.println("Stack depth = " + stack.getDepth());

        String findValue = (String) stack.find("poi2134gd");
        System.out.println("Found " + findValue);

        System.out.println(stack);
    }

    private static void runIntTest(){
        System.out.println("\nSTACK OF INTS");

        Stack stack = new Stack<Integer>(Integer.class, 50);
        stack.push(1)
                .push(15)
                .push(80)
                .push(-555)
                .push(42);

        Integer popValue = (Integer) stack.pop();
        System.out.println("Popped value = " + popValue);

        stack.push(3)
                .push(0);

        System.out.println("Stack depth = " + stack.getDepth());

        Integer findValue = (Integer) stack.find(15);
        System.out.println("Found " + findValue);

        System.out.println(stack);
    }
}
