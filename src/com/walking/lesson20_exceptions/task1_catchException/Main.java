package com.walking.lesson20_exceptions.task1_catchException;

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
    public static void main(String[] args) throws FileNotFoundException {
        FileService fs = new FileService(
                new File("text", FileType.text, 123),
                new File("image",FileType.image,100222),
                new File("audio",FileType.audio, 3567788),
                new File("video",FileType.video,700999999)
        );
        Scanner in = new Scanner(System.in);
        System.out.println("File name:");
        String name = in.next();
        System.out.println("File type:");
        String type = in.next();
        FileType ft;
        try {
            ft = FileType.valueOf(type);
        } catch (Exception e){
            throw new FileNotFoundException("File type is incorrect!");
        }
        System.out.println(fs.findFile(name, ft));
        System.out.println(fs.findFileWithException(name, ft));
    }
}
