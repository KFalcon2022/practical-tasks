package com.walking.lesson20_exceptions.task1_throwsException;

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
 * Если нет, то выбросьте исключение FileNotFoundException.
 * <p>
 * Подсказка: throws можно использовать в том числе в main().
 */
public class Main {
    public static void main(String[] args) {
        File[] files = createFilesArray();

        String fileName = getFileNameFromUser();

        FileService fileService = new FileService(files);

        try {
            File foundFile = fileService.findFileByName(fileName);

            System.out.println(foundFile);
        }
        catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String getFileNameFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert file name: ");

        String s = scanner.nextLine();

        scanner.close();

        return s;
    }

    public static File[] createFilesArray() {
        File[] files = new File[5];

        files[0] = new File("first", 10, FileType.TEXT);
        files[1] = new File("second", 80, FileType.IMAGE);
        files[2] = new File("third", 7000, FileType.AUDIO);
        files[3] = new File("fourth", 50000, FileType.VIDEO);
        files[4] = new File("fifth", 300, FileType.TEXT);

        return files;
    }
}
