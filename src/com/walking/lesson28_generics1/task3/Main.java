package com.walking.lesson28_generics1.task3;

public class Main {
    public static void main(String[] args) throws NoElementException {
        String[] strings = new String[]{"one", "two", "three", "four", "five"};
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5};

        Generic<String> genString = new Generic<>(strings);
        Generic<Integer> genInteger = new Generic<>(integers);

        System.out.println(genString.findElement("one"));
        System.out.println(genString.findElement("hello"));
        System.out.println(genInteger.findElement(5));
        System.out.println(genInteger.findElement(6));

    }

    static class Generic<T> {
        private T[] array;

        public Generic(T[] array) {
            this.array = array;
        }

        public T findElement(T element) throws NoElementException {
            for (T a : array) {
                if (element.equals(a)) {
                    return a;
                }
            }
            throw new NoElementException();
        }
    }
}