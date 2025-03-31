package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.files.File;
import com.walking.lesson20_exceptions.task1_catchException.files.FileNotFoundException;

import java.util.Scanner;

import static com.walking.lesson20_exceptions.task1_catchException.files.FileType.*;

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
        File[] files = new File[8];
        files[0] = new File("Девятый вал", "109 КБ", PICTURE);
        files[1] = new File("Шрек 2", "128 МБ", VIDEO);
        files[2] = new File("Три товарища", "895 КБ", TEXT);
        files[3] = new File("Эфир", "7.4 МБ", AUDIO);
        files[4] = new File("Пока течёт река", "930 КБ", TEXT);
        files[5] = new File("М", "8 МБ", AUDIO);
        files[6] = new File("Душа", "134 МБ", VIDEO);
        files[7] = new File("Смешной мем", "99 КБ", PICTURE);

        Scanner in = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String name = in.nextLine();

        try{
            File file = findFile(files, name);
            System.out.println(file);
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static File findFile(File[] files, String name) throws FileNotFoundException {
        for(File file : files) {
            if(name.equals(file.getName())) {
                return file;
            }
        }
        throw new FileNotFoundException("Искомый файл не существует.");
    }
}
