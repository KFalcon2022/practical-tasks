package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.files.File;
import com.walking.lesson20_exceptions.task1_catchException.files.types.Type;

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

        File[] files = createFiles();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file`s name: ");
        String name = scanner.nextLine();

        scanner.close();

        try {
            File searchFile = searchFile(files, name);
            System.out.println(searchFile);
        } catch (FileNotFoundException e) {
            System.out.println("Искомый файл не существует");
        }
    }

    private static File searchFile(File[] files, String name) throws FileNotFoundException {
        for (File file: files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        throw new FileNotFoundException("Искомый файл не существует");
    }

    private static File[] createFiles() {
        return new File[]{
                new File("File1", 1024, Type.Audio),
                new File("File2", 2048, Type.Video)
        };
    }
}
