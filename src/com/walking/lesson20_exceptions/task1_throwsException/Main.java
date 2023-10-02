package com.walking.lesson20_exceptions.task1_throwsException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.FileType;
import com.walking.lesson20_exceptions.task1_throwsException.service.FileService;

import java.io.FileNotFoundException;
import java.util.Scanner;

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
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileService fileService = new FileService();
        File[] files = {
                new File("История", 256, FileType.TEXT),
                new File("Рассказ", 287, FileType.TEXT),
                new File("Картина", 555, FileType.IMAGE),
                new File("Фотография", 432, FileType.IMAGE),
                new File("Аудиокнига", 876, FileType.AUDIO),
                new File("Музыка", 567, FileType.AUDIO),
                new File("Фильм", 77856, FileType.VIDEO),
                new File("Мультфильм", 56756, FileType.VIDEO),
        };

        System.out.println("Введите название файла:");
        Scanner scanner = new Scanner(System.in);
        String searchingFile = scanner.nextLine();
        scanner.close();

        System.out.println(fileService.searchFile(files, searchingFile));

    }

    private static String searchFile(File[] files, String searchingFile) throws FileNotFoundException {

        for (File file : files) {
            if (file.getName().equals(searchingFile)) {
                return file.toString();
            }
        }
        throw new FileNotFoundException();
    }
}
