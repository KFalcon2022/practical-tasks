package com.walking.lesson33_files_2.task1.repository;

import java.io.*;

interface CarReader {
    default String read(File source) {
        try (BufferedReader carBufferedReader = new BufferedReader(new FileReader(source))) {
            String currentLine;
            StringBuilder carCandidates = new StringBuilder();

            while ((currentLine = carBufferedReader.readLine()) != null) {
                carCandidates.append(currentLine);
                        /* метод readLine() не читает символы перевода строки,
                           но текущая реализация использует их для разделения данных разных объектов
                           поэтому добавляем их отдельно */
                carCandidates.append('\n');
            }

            return carCandidates.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: %s ".formatted(source), e);
        } catch (IOException e) {
            throw new RuntimeException("io exception, e");
        }
    }
}
