package com.walking.lesson29.Task1;

/*
Реализуйте обобщенный тип, хранящий параметризованное поле.
Также в классе Main реализуйте параметризованый метод, принимает первым параметром объект вашего дженерика,
вторым — объект типа, которым параметризован объект первого параметра.
Метод должен возвращать значение поля дженерика, если оно != null, в противном случае — возвращать второй параметр.
 */

public class Main {
    public static void main(String[] args) {
        Generic1 generic;
        generic = new Generic1(new Integer(5));

        System.out.println(ifNull(generic, new Integer(15)));

        generic.setValue(null);

        System.out.println(ifNull(generic, new Integer(15)));
    }

    public static class Generic1<T> {
        public T obj;

        public Generic1(T obj){this.obj = obj;}

        public T getValue(){return obj;}

        public void setValue(T value){obj = value;}
    }

    public static <R> R ifNull(Generic1 obj, R ret){
        if (obj.getValue() != null) {return (R)obj.getValue();}
        return ret;
    }
}
