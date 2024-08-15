package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.InvalidFullNameException;
import com.walking.lesson30_regex.task2.model.FullName;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static final String FULL_NAME_PATTERN = "^([A-Я][а-я]+-[А-Я][а-я]+)|([А-Я][а-я]+)\\s[А-Я][а-я]+\\s[А-Я][а-я]+$";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your full name: ");
        String input = scan.nextLine();

        scan.close();


        FullName fullName = getFullName(input);
        String toStringFullName = fullName.toString();

        System.out.println(toStringFullName);

        // test validator
        System.out.println(isValidFullName("Аксенов Тимур Михайлович"));
        System.out.println(isValidFullName("Волкова Мирослава Данииловна"));
        System.out.println(isValidFullName("Гордеева Екатерина Матвеевна"));
        System.out.println(isValidFullName("Иванова Алина Артемовна"));
        System.out.println(isValidFullName("Киреева-Леонова Дарья Львовна"));
        System.out.println(isValidFullName("Левин Мирослав Савельевич"));
        System.out.println(isValidFullName("Платонов Артур богданович")); // false
        System.out.println(isValidFullName("Сазонов григорий Богданович")); // false
        System.out.println(isValidFullName("Соколов-Дмитриев иван филиппович")); // false
        System.out.println(isValidFullName("Фокина-Любимова Кира Александровна"));

    }

    private static FullName getFullName(String input) {
        if (!isValidFullName(input)) {
            throw new InvalidFullNameException(input);
        }

        String[] splitFullName = input.split(" ");

        return new FullName(splitFullName[0], splitFullName[1], splitFullName[2]);
    }

    private static boolean isValidFullName(String input) {
        Pattern fullNamePattern = Pattern.compile(FULL_NAME_PATTERN);
        Matcher fullNameMatcher = fullNamePattern.matcher(input);

        return fullNameMatcher.matches();
    }
}
