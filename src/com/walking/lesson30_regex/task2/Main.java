package com.walking.lesson30_regex.task2;

import java.util.Scanner;

import com.walking.lesson30_regex.task2.model.FullName;
import com.walking.lesson30_regex.task2.model.ValidationException;

/**
 * Реализуйте метод для работы с ФИО.
 * Входным параметром должна являться строка,
 * содержащая русскоязычное ФИО.
 * Фамилия, имя и отчество должны начинаться с прописной буквы
 * и быть разделены пробелами.
 * Фамилия может быть двойной и писаться через дефис
 * (каждая часть фамилии начинается с прописной буквы).
 * Если строка валидна – верните ФИО, обернутое в класс «Полное имя»,
 * содержащий фамилию, имя и отчество.
 * Если невалидна – бросьте из метода исключение, указывающее на ошибку валидации.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Insert fio:");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        FullName fn=null;
        try {
            fn=getFullName(s);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        if (fn!=null){
            System.out.println(fn.toString());
        }
    }
    private static FullName getFullName(String input) throws ValidationException{
        input=input.strip();
        String[] words=input.split("\\s+", 3);
        if (words.length<3) 
            throw new ValidationException("Have not enough words");
        if (words[2].contains(" ")) 
            throw new ValidationException("Too many words");
        if (!words[0].matches("^[А-Я].*")) 
            throw new ValidationException("Last name not started with big letter");
        if (!words[1].matches("^[А-Я].*")) 
            throw new ValidationException("Name not started with big letter");
        if (!words[2].matches("^[А-Я].*")) 
            throw new ValidationException("Surname not started with big letter");
        if (!words[1].matches("^[А-Я][а-я]*$")) 
            throw new ValidationException("Name must contain only а-я letters");
        if (!words[2].matches("^[А-Я][а-я]*$")) 
            throw new ValidationException("Surname must contain only а-я letters");
        if (!words[0].matches("^[А-Я][а-я]*$")&!words[0].matches("^[А-Я][а-я]*-[А-Я][а-я]*$"))
            throw new ValidationException("Last name must contain only а-я letters or dash");


        return new FullName(words[0],words[1],words[2]);
    }
}
