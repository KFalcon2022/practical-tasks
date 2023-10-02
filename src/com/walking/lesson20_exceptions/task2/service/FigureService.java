package com.walking.lesson20_exceptions.task2.service;

import com.walking.lesson20_exceptions.task2.exception.InputValidationException;
import com.walking.lesson20_exceptions.task2.model.Figure;
import com.walking.lesson20_exceptions.task2.model.Square;
import com.walking.lesson20_exceptions.task2.model.Triangle;

public class FigureService {

    public Figure getFigure(int choosedFigure, int sideLength) {
        if (choosedFigure == 1) {
            return new Square(sideLength);
        } else if (choosedFigure == 2) {
            return new Triangle(sideLength);
        } else {
            throw new InputValidationException("Ввод должен быть 1 или 2", choosedFigure);
        }
    }
}
