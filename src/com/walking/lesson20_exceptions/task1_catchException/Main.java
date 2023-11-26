package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.InfoType;

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
                new File("pizda", 6, InfoType.PICTURE),
                new File("polovaya_eblya", 132, InfoType.VIDEO),
                new File("instruction", 2, InfoType.TEXT),
                new File("tractor_driver", 300, InfoType.VIDEO),
                new File("weekends", 40, InfoType.PICTURE)
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter find file name: ");
        String name;
        name = sc.nextLine();

        File findedFile = FindFile.findFile(files, name);
        System.out.println(findedFile);
    }

}

