package com.walking.lesson28_generics1.task2.Obertka;

public class Obertka <T extends Object>{
    T obj;

    public Obertka(T obj){
        this.obj = obj;
    }
    public boolean isNull(){
        return obj == null;
    }
    public T getObj(){
        return obj;

    }
    public void setObj(T obj){
        this.obj = obj;
    }
}
