package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.FileType;
import com.walking.lesson20_exceptions.task1_catchException.service.FileService;

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
 * Если нет, то выведите сообщение «Искомый файл не существует».
 */
public class Main {

    public static void main(String[] args) {
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

        try {
            System.out.println(fileService.searchFile(files, searchingFile));
        } catch (FileNotFoundException e) {
            System.out.println("Искомый файл не существует");
        }
    }
}
