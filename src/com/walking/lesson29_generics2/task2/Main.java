package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.model.NumberExponentiater;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Используя Задачу 1 из урока Generics. Часть I,
 * реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
  List<?super Number> a = new List<>() {
      @Override
      public int size() {
          return 0;
      }

      @Override
      public boolean isEmpty() {
          return false;
      }

      @Override
      public boolean contains(Object o) {
          return false;
      }

      @Override
      public Iterator<Number> iterator() {
          return null;
      }

      @Override
      public Object[] toArray() {
          return new Object[0];
      }

      @Override
      public <T> T[] toArray(T[] a) {
          return null;
      }

      @Override
      public boolean add(Number number) {
          return false;
      }

      @Override
      public boolean remove(Object o) {
          return false;
      }

      @Override
      public boolean containsAll(Collection<?> c) {
          return false;
      }

      @Override
      public boolean addAll(Collection<? extends Number> c) {
          return false;
      }

      @Override
      public boolean addAll(int index, Collection<? extends Number> c) {
          return false;
      }

      @Override
      public boolean removeAll(Collection<?> c) {
          return false;
      }

      @Override
      public boolean retainAll(Collection<?> c) {
          return false;
      }

      @Override
      public void clear() {

      }

      @Override
      public Number get(int index) {
          return null;
      }

      @Override
      public Number set(int index, Number element) {
          return null;
      }

      @Override
      public void add(int index, Number element) {

      }

      @Override
      public Number remove(int index) {
          return null;
      }

      @Override
      public int indexOf(Object o) {
          return 0;
      }

      @Override
      public int lastIndexOf(Object o) {
          return 0;
      }

      @Override
      public ListIterator<Number> listIterator() {
          return null;
      }

      @Override
      public ListIterator<Number> listIterator(int index) {
          return null;
      }

      @Override
      public List<Number> subList(int fromIndex, int toIndex) {
          return null;
      }
  };
  a.add(2,2);
  a.add(2,2.2);
  a.add(2,2.2);
}
}