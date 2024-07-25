package com.walking.lesson20_exceptions.task1_catchException;

import com.walking.lesson20_exceptions.task1_catchException.model.File;
import com.walking.lesson20_exceptions.task1_catchException.model.TypeInformation;

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
        File[] files = initFiles();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String file = scanner.nextLine();
        scanner.close();

        seachFile(file, files);
    }

    private static void seachFile (String file, File [] files) {
        try {
            for (File f : files) {
                if(f.getFileName().equals(file)) {
                    System.out.println(f);
                    return;

                }
            }
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("Искомый файл не найден.");
        }
    }

    private static File[] initFiles() {
        File file1 = new File("Obj.111", 2048, TypeInformation.AUDIO);
        File file2 = new File("Obj.222", 1024, TypeInformation.IMAGE);
        File file3 = new File("Obj.333", 2048, TypeInformation.TEXT);
        File file4 = new File("Obj.444", 1024, TypeInformation.VIDEO);
        File file5 = new File("Obj.555", 1024, TypeInformation.AUDIO);
        File file6 = new File("Obj.666", 1024, TypeInformation.IMAGE);
        File file7 = new File("Obj.777", 2048, TypeInformation.TEXT);
        File file8 = new File("Obj.888", 1024, TypeInformation.VIDEO);
        File file9 = new File("Obj.999", 2048, TypeInformation.AUDIO);
        File file10 = new File("Obj.000", 2048, TypeInformation.AUDIO);

        return new File[]{file1, file2, file3, file4, file5, file6, file7, file8, file9, file10};
    }
}
