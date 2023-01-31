package com.walking.lesson20_exceptions.task1_throwsException;


import com.walking.lesson20_exceptions.task1_throwsException.model.DataType;
import com.walking.lesson20_exceptions.task1_throwsException.model.File;

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

        System.out.println("Input file name for searching:");
        Scanner scanner = new Scanner(System.in);
        String searchedFileName = scanner.nextLine();
        scanner.close();

        File foundFile = findFile(searchedFileName);
        System.out.println(foundFile);
    }

    private static File findFile(String fileName) throws FileNotFoundException {
        for (File file : getFiles()) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }

        throw new FileNotFoundException();
    }

    private static File[] getFiles() {
        return new File[]{
                new File("1.txt", 10, DataType.TEXT),
                new File("file_text.txt", 10, DataType.TEXT),
                new File("2.mp3", 20, DataType.AUDIO),
                new File("file_audio.mp3", 20, DataType.AUDIO),
                new File("3.mpg", 30, DataType.VIDEO),
                new File("file_video.mpg", 30, DataType.VIDEO),
        };
    }
}
