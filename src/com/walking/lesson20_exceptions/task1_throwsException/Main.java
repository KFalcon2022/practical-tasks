package com.walking.lesson20_exceptions.task1_throwsException;

import com.walking.lesson20_exceptions.task1_throwsException.model.File;
import com.walking.lesson20_exceptions.task1_throwsException.model.TypeFile;

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
        File[] files = new File[]{
                new File("Картинка1",1345, TypeFile.IMAGE),
                new File("Картинка2",1345, TypeFile.IMAGE),
                new File("Картинка3",1422, TypeFile.IMAGE),
                new File("МоёВидео",234567, TypeFile.VIDEO),
                new File("Видео2",1345, TypeFile.VIDEO),
                new File("Текст",42, TypeFile.TEXT),
                new File("Текст2",2, TypeFile.TEXT),
                new File("Текст1",111, TypeFile.TEXT),
                new File("Музыка",3232, TypeFile.AUDIO),
                new File("Музыка1",2345, TypeFile.TEXT)};

        Scanner in = new Scanner(System.in);

        System.out.println("Введите название файла");
        String userFileName = in.nextLine();

        in.close();

        File userFile =  findFile(files,userFileName);
        System.out.println(userFile);
    }
    public static File findFile(File [] files, String userFileName) throws FileNotFoundException {
        for(File file: files)
        {
            if(userFileName.equals(file.getName()))
            {
                return file;
            }
        }
        throw new FileNotFoundException("Искомый файл не существует");
    }
}
