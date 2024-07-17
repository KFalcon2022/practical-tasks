package com.walking.lesson37_collection_list.task2.model;

import java.util.Collection;
import java.util.Iterator;

public class Stack<Type> implements Collection<Type> {
    private Type value;
    private Stack<Type> next;
    private int index;

    public Stack(){
        this.index=0;
    }
    private Stack(Type value, int index, Stack<Type> stack){
        this.value=value;
        this.index=index;
        this.next=stack;
    }

    public int length(){
        return index;
    }

    public Type push(Type element){
        if (this.value==null){
            this.value=element;
            this.index++;
        } else{
            this.next=new Stack<Type>(this.value, this.index, this.next);
            this.value=element;
            this.index++;
        }
        return peek();
    }

    public Type peek(){
        return value;
    }

    public Type pop(){
        Type temp;
        if (index==0) throw new RuntimeException("No more elements");
        if (index==1){
            temp=this.value;
            this.value=null;
            index=0;    
            return temp;        
        }
        temp=value;
        this.index=next.index;
        this.value=next.value;
        this.next=next.next;
        return temp;
    }

    public int findElement(Type value){
        var temp=this;
        while (temp.next!=null) {
            if(temp.value.equals(value)){
                return temp.index;
            }
            temp=temp.next;
        }
        throw new RuntimeException("Not found");
    }

    public String[] getStrings(){
        String[] s=new String[this.index];
        var temp=this;
        while (temp.next!=null) {
            s[temp.index-1]=temp.value.toString();
            temp=temp.next;
        }
        s[temp.index-1]=temp.value.toString();
        return s;
    }
    @Override
    public boolean add(Type arg0) {
        push(arg0);
        return true;
    }
    @Override
    public boolean addAll(Collection<? extends Type> c) {
        int before=this.index;
        for (Type t : c) {
            add(t);
        }
        if (before!=this.index){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void clear() {
        this.index=0;
        this.value=null;
        this.next=null;
    }
    @Override
    public boolean contains(Object o) {
        for (Type value : this) {
            if(value.equals(o)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if(!contains(object))
            return false;
        }
        return true;
    }
    @Override
    public boolean isEmpty() {
        return this.index==0;
    }
    @Override
    public Iterator<Type> iterator() {
        Stack<Type> temp=new Stack<>(value, index, next);
        Iterator<Type> it=new Iterator<Type>(){
            @Override
            public boolean hasNext(){
                return !temp.isEmpty();
            }

            @Override
            public Type next() {
                return temp.pop();
            }
        };
        return it;
    }
    @Override
    public boolean remove(Object o) {
        if (!contains(o)){
            return false;
        }
        Stack<Type> newStack=new Stack<>();
        for (Object value : toArray()) {
            if (!value.equals(o)){
                newStack.push((Type)value);
            }
        }
        this.index=newStack.index;
        this.next=newStack.next;
        this.value=newStack.value;
        return true;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean change=false;
        for (Object object : c) {
            if (remove(object)){
                change=true;
            }
        }
        return change;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        Stack<Type> newStack=new Stack<>();
        for (Object value : toArray()) {
            for (Object object : c) {
                if (value.equals(object)){
                    newStack.push((Type)object);
                    break;
                }
            }
        }
        boolean change=(length()!=newStack.length());
        this.value=newStack.value;
        this.next=newStack.next;
        this.index=newStack.index;
        return change;
    }
    @Override
    public int size() {
        return length();
    }
    @Override
    public Object[] toArray() {
        var temp=this;
        Object[] result=new Object[this.index];
        while (temp.next!=null) {
            result[temp.index-1]=temp.value;
            temp=temp.next;
        }
        result[temp.index-1]=temp.value;
        return result;
    }
    @Override
    public <T> T[] toArray(T[] arg0) {
        Stack<Type> temp=this;
    if (arg0.length < length())
    arg0 = (T[])java.lang.reflect.Array.newInstance(
        arg0.getClass().getComponentType(), length());
    Object[] result = arg0;
    while (temp.next!=null) {
        result[temp.index-1]=temp.value;
        temp=temp.next;
    }
    result[temp.index-1]=temp.value;

    if (arg0.length > length())
    arg0[length()] = null;
        return arg0;
    }
}
