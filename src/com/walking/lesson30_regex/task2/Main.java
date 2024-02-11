package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.NameValidationException;
import com.walking.lesson30_regex.task2.model.FullName;

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
        System.out.println(checkName("Иванов Иван Иванович"));
        System.out.println(checkName("Иванов-Иванов Иван Иванович"));
        System.out.println(checkName("Иванов-Иванов И Иванович"));
        System.out.println(checkName("И-Иванов И Иванович"));
        System.out.println(checkName("Иванов иван Иванович"));
//        Все равно упадет на 30й строке.
//        System.out.println(checkName("И-иванов И Иванович"));
//        System.out.println(checkName("Иванов Иван иванович"));
//        System.out.println(checkName("ИваНов Иван Иванович"));
//        System.out.println(checkName("Ivanov Ivan"));
    }
    private static FullName checkName(String inputName){
        String nameRegex="^[А-Я][а-я]+(-[А-Я][а-я]+)? {1}[А-Я][а-я]+ {1}[А-Я][а-я]+$";
        if (inputName.matches(nameRegex)){
            String[] partsOfName = inputName.split(" ");
            return new FullName(partsOfName[0],partsOfName[1],partsOfName[2]);
        }
        throw new NameValidationException(inputName);
    }
}
