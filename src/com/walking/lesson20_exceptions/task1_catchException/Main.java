package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.FileType;
import com.walking.lesson20_exceptions.task1_catchException.service.FileNotFoundException;
import com.walking.lesson20_exceptions.task1_catchException.service.FileService;

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
        File[] files = {new File("pic1", FileType.IMAGE, 400),
                        new File("pic2", FileType.IMAGE, 800),
                        new File("pic3", FileType.IMAGE, 1200),
                        new File("video1", FileType.VIDEO, 10_000_000),
                        new File("music1", FileType.AUDIO, 5_000_000),
                        new File("doc1", FileType.TEXT, 500)};

        Scanner io = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String userFile = io.nextLine();
        io.close();

        FileService fileService = new FileService(files);
        try {
            System.out.println(fileService.search(userFile));
        }
        catch (FileNotFoundException ex) {
            System.out.println("Искомый файл не найден");
        }

    }
}
