package com.walking.lesson20_exceptions.task1_throwsException;

import com.walking.lesson20_exceptions.task1_throwsException.model.File;
import com.walking.lesson20_exceptions.task1_throwsException.model.InformationType;
import com.walking.lesson20_exceptions.task1_throwsException.service.FileService;

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
        Scanner scanner = new Scanner(System.in);

        FileService fileService = new FileService(initFiles());

        System.out.println("Enter a file's name: ");
        String name = scanner.nextLine();

        System.out.println(fileService.findFile(name).toString());


        // Очень сильно прошу объяснить разницу между обычной "Всплывающей" ошибкой
        // если код написан неправильно, но его удалось запустить,
        // и этой итеррацией задачи, а именно всплывающем сообщении,
        // ибо процесс завершается с ОДНИМ выходным кодом,
        // а не НУЛЁМ, как это обычно бывает при верном решении задач.
        // при том, что я запускал
    }

    private static File[] initFiles() {
        File file1 = new File("text", 140, InformationType.TXT);
        File file2 = new File("image", 140, InformationType.JPG);
        File file3 = new File("audio", 140, InformationType.MP3);
        File file4 = new File("video", 140, InformationType.MP4);

        return new File[]{file1, file2, file3, file4};
    }
}
