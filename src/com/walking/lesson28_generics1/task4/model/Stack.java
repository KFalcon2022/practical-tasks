package com.walking.lesson28_generics1.task4.model;

import com.walking.lesson28_generics1.task4.exception.ElementNotFoundException;
import com.walking.lesson28_generics1.task4.exception.StackIsEmptyException;
import java.util.Objects;
public class Stack<T> {
    private Element<T> top;

    public void push(T newElement){
        this.top = new Element<>(newElement, this.top);
    }

    public Element<T> getTop() {
        return top;
    }

    public String getAsArrayStr(Element<T> current){
        if (current == null){
            return "[]";
        }
        String currentStr = current.toString();
        Element<T> next = current.getNext();

        String prefix = current.equals(this.top) ? "[" : "";

        if (next == null) {
            return currentStr+"]";
        } else {
            return prefix + currentStr + "," + getAsArrayStr(next);
        }
    }

    public Element<T> pop(){
        if (this.top == null){
            throw  new StackIsEmptyException();
        }
        Element<T> element = this.top;
        this.top = element.getNext();
        return element;
    };

    public int getDepth(){
        if (this.top == null){
            return 0;
        } else {
            return getDepth(this.top);
        }
    }

    public int getDepth(Element<T> element){

        if (element == null) {
            return 0;
        } else {
            return 1 + getDepth( element.getNext());
        }
    }

    public Element<T> search(T desired){

        Element<T> element = this.top;

        while (element != null){
            if (!Objects.equals(element.getCurrent(),desired)) {
                element = element.getNext();
            } else {
                return element;
            }
        }

        throw new ElementNotFoundException();
    }

    public void delete(T desired){
        Element<T> temp = this.top;

        //если у нас удаляемый равен вершине стека
        if (Objects.equals(this.top.getCurrent(),desired)){
            this.top = this.top.getNext();
            return;
        }

        //ищем совпадение для след элемента
        while (temp.getNext() !=null ){
            if (Objects.equals(temp.getNext().getCurrent(),desired)){
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }

        throw new ElementNotFoundException( );
    }
}
