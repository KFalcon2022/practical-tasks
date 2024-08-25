package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.FileTypes;
import com.walking.lesson20_exceptions.task1_throwsException.file_service.FileService;

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
        FileService fileService = new FileService(initFileArray());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String fileName = scanner.nextLine();
        scanner.close();
        try {
            File foundFile = fileService.searchFile(fileName);
            System.out.println(foundFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }

    private static File[] initFileArray() {
        File file1 = new File("1", 1024, FileTypes.TEXT);
        File file2 = new File("2", 12351, FileTypes.IMAGE);
        File file3 = new File("3", 1235351, FileTypes.AUDIO);
        File file4 = new File("4", 5342, FileTypes.TEXT);
        File file5 = new File("5", 1223511, FileTypes.VIDEO);
        return new File[]{file1, file2, file3, file4, file5};
    }
}
