package com.walking.lesson20_exceptions.task1_throwsException;

import com.walking.lesson20_exceptions.task1_throwsException.models.File;
import com.walking.lesson20_exceptions.task1_throwsException.models.FileType;
import com.walking.lesson20_exceptions.task1_throwsException.services.FileService;

import java.io.FileNotFoundException;
import java.util.Random;
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
    public static void main(String[] args) throws Exception {
        String nameForSearch = getInputFile();
        FileService fileService = null;
        fileService = new FileService(createFileSystem(10));
        try {
            fileService.findFile(nameForSearch);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    private static String getInputFile(){
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String result = scannerIn.nextLine();
        scannerIn.close();
        return result;
    }
    private static File[] createFileSystem (int amount) throws Exception {
        File[] files = new File[amount];
        for (int i=0;i<amount;i++){
            files[i]=new File ("Name_"+i, getRandomSize(), getRandomType());
        }

        return files;
    }
    private static int getRandomSize(){
        Random rnd = new Random();
        return rnd.nextInt(1000);
    }
    private static FileType getRandomType() throws Exception {
        Random rnd = new Random();
        int length=FileType.values().length;
        int rndResult=rnd.nextInt(FileType.values().length-1);
            return FileType.getOrdinalType(rndResult);
    }
}
