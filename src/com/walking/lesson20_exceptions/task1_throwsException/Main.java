package com.walking.lesson20_exceptions.task1_throwsException;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.TypeFile;

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
        File[] fs=new File[4];
        fs[0]=new File("List", TypeFile.Text, 150);
        fs[1]=new File("BirthDay",TypeFile.Image, 30040);
        fs[2]=new File("Fire", TypeFile.Video, 4040432);
        fs[3]=new File("Notepad", TypeFile.Text);
        File myFile;
        String requestedName;
        Scanner sc=new Scanner(System.in);
        System.out.println("Insert file name:");
        requestedName=sc.nextLine();
        sc.close();
        myFile=findFile(fs, requestedName);
        System.out.println(myFile.toString());

    }
    public static File findFile(File[] fs, String fileName) throws FileNotFoundException{
        for (File x:fs){
            if (x.getName().equals(fileName)){
                return x;
            }
        }
        throw new FileNotFoundException("Искомый файл не существует");
    }
}
