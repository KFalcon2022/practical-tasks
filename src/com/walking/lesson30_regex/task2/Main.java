package com.walking.lesson30_regex.task2;

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
    public static void main(String[] args) throws Exception {
        Person p = createPerson("Иванов Иван Иванович");
        System.out.println(p);

        p = createPerson("Иванов Иван");
        System.out.println(p);

        p = createPerson("Иванов-Петров Иван");
        System.out.println(p);

        p = createPerson("Иванов-Петров Иван1");
        System.out.println(p);
    }

    static Person createPerson(String fio) throws Exception {
        String[] splitFio = fio.split(" ");
        int cnt = splitFio.length;
        String mask = "[А-Я]([а-я]*)";
        if (cnt < 2 || cnt > 3){
            throw new Exception("ФИО некорректно или отсутствует");
        }
        if (splitFio[0] == null || !splitFio[0].matches("^" + mask + "(-" + mask + ")?$")){
            throw new Exception("Фамилия некорректна или отсутствует");
        }
        mask = "^" + mask + "$";
        if (splitFio[1] == null || !splitFio[1].matches(mask)){
            throw new Exception("Имя некорректно или отсутствует");
        }
        if (cnt == 3){

            if (splitFio[2] != null && !splitFio[2].matches(mask)){
                throw new Exception("Отчество некорректно или отсутствует");
            }
        }
        return new Person(splitFio[0],splitFio[1], cnt==3?splitFio[2]:"");
    }
}
