package com.walking.lesson20_exceptions.task1_throwsException;

import com.walking.lesson20_exceptions.task1_catchException.File;
import com.walking.lesson20_exceptions.task1_catchException.FileService;
import com.walking.lesson20_exceptions.task1_catchException.InformationType;

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
        FileService fileService = new FileService(initFiles());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file's name: ");
        String name = scanner.nextLine();
        scanner.close();


           File foundFile = fileService.findFile(name);
            System.out.println(foundFile);



    }


    private static com.walking.lesson20_exceptions.task1_catchException.File[] initFiles() {
        File file1 = new File("text1", 1, InformationType.TEXT);
        File file2 = new File("picture1", 5, InformationType.PICTURE);
        File file3 = new File("audio1", 1, InformationType.AUDIO);
        File file4 = new File("video1", 2, InformationType.VIDEO);
        File file5 = new File("text2", 5, InformationType.TEXT);

        return new File[]{file1, file2, file3, file4, file5};
    }
}
