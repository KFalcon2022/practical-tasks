package com.walking.lesson28_generics1.task2;

public class Main {
    public static void main(String[] args) {
        Generic<Integer> genericInt1 = new Generic<>(3);
        Generic<Integer> genericInt2 = new Generic<>(null);
        Generic<String> genericString = new Generic<>(null);
        Generic<Float> genericFloat = new Generic<>(5.3f);
        Generic<Character> genericChar = new Generic<>(null);

        System.out.println(genericInt1.isEmpty());
        System.out.println(genericInt2.isEmpty());
        System.out.println(genericString.isEmpty());
        System.out.println(genericFloat.isEmpty());
        System.out.println(genericChar.isEmpty());
    }

    static class Generic<T> {
        private T value;

        public Generic(T value) {
            this.value = value;
        }

        public boolean isEmpty() {
            if (value == null) {
                return true;
            }
            return false;
        }
    }
}