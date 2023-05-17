package com.walking.lesson20_exceptions.task1_throwsException;

/**
 * Создайте массив, имитирующий простейшую файловую систему и содержащий объекты файлов.
 * <p>
 * Реализуйте класс «Файл» содержит название файла, его размер и тип информации
 * (Текст, изображение, аудио, видео. Рекомендую задать типы информации через Enum).
 * <p>
 * Реализуйте механизм поиска по файлам.
 * Метод, реализующий поиск должен выбрасывать FileNotFoundException, если файл не найден.
 * Если файл с названием, введенным пользователем с клавиатуры,
 * существует – вывести на экран информацию о нем
 * (допустимо использовать переопределенный toString()).
 * Если нет, то выбросьте исключение FileNotFoundException.
 * <p>
 * Подсказка: throws можно использовать в том числе в main().
 */

import com.walking.lesson20_exceptions.task1_catchException.model.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File[] files = new File[]{
                new File("a", 10, FileType.TEXT),
                new File("b", 15, FileType.TEXT)};

        System.out.print("Enter file name:");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        scanner.close();

        FileService fileService = new FileService();
        File file = fileService.searchFileByName(files, name);
        System.out.println(file.toString());
    }
}
