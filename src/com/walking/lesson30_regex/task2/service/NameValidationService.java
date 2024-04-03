package com.walking.lesson30_regex.task2.service;

import com.walking.lesson30_regex.task2.exception.InvalidFullNameException;
import com.walking.lesson30_regex.task2.model.FullName;

public class NameValidationService {
    //Каждый элемент имени обязательно! должен:
    //начинаться с прописной буквы
    //оканчиваться строчной буквой
    //
    //в фамилии опционально допустима вторая часть с теми же правилами через дефис
    public static final String VALID_FIRST_NAME = "^[А-Я][а-я]*(-[А-Я][а-я]*)?$";
    public static final String VALID_NON_FIRST_NAME = "^[А-Я][а-я]*$";


    public static FullName getFullName(String rawFullName) {
        String[] splitRawFullName = rawFullName.split(" ");

        if (isValidFullName(splitRawFullName)) {
            return new FullName(splitRawFullName[0], splitRawFullName[1], splitRawFullName[2]);
        } else {
            throw new InvalidFullNameException(rawFullName);
        }
    }

    private static boolean isValidFullName(String[] splitRawFullName) {
        //считаем валидными для парсинга строки строго с 3-мя разделенными пробелами элементами(словами)
        return (splitRawFullName.length == 3
                && isValidFirstName(splitRawFullName[0])
                && isValidNonFirstName(splitRawFullName[1])
                && isValidNonFirstName(splitRawFullName[2]));
    }

    private static boolean isValidFirstName(String name) {
        return name.matches(VALID_FIRST_NAME);
    }

    private static boolean isValidNonFirstName(String name) {
        return name.matches(VALID_NON_FIRST_NAME);
    }
}
