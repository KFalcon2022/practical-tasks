package com.walking.lesson20_exceptions.task1_catchException;

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
        List<Files> list = new ArrayList<>();
        list.add(new Files("File1", FileTypes.VIDEO, ".mp4"));
        list.add(new Files("File2"));
        list.add(new Files("File3", FileTypes.AUDIO, ".wav"));
        list.add(new Files("File4", FileTypes.PICTURE, ".png"));
        try {
            System.out.println(new fileFinder((ArrayList<Files>) list).findFile("File3"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
