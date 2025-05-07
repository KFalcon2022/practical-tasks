package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.Type;

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
        File[] files = new File[]{
                new File("Cover.jpg", 300, Type.IMAGE),
                new File("Lesson20.mp4", 59874365, Type.VIDEO),
                new File("Ekkel.pdf", 45675, Type.TEXT),
                new File("Songs.mp3", 98766, Type.AUDIO)};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String name = scanner.nextLine();

        try {
            System.out.println(searchFile(files, name));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static File searchFile(File[] files, String name) throws FileNotFoundException {
        for (File f : files) {
            if (name.equals(f.getName())) {
                return f;
            }
        }
        throw new FileNotFoundException("File does not exist");
    }
}

