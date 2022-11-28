package com.walking.lesson19_object_methods.model;

import java.util.Objects;

public class Car {
    //    Уникальным идентификатором будем считать совокупность значений number и year
    private final String number;
    private final int year;

    private String color;
    private boolean actualTechnicalInspection;

    //    Для ускорения поиска запишем хэшкод в отдельное поле. Это допустимо, учитывая,
//    что хэшкод мы считаем лишь по неизменяемым полям и пересчитывать его
//    при каждом вызове hashcode() бессмысленно.
//    Похожий, но чуть более изощренный принцип использует класс String
    private int hashcode;

    public Car(String number, int year, String color, boolean actualTechnicalInspection) {
        this.number = number;
        this.year = year;
        this.color = color;
        this.actualTechnicalInspection = actualTechnicalInspection;

//        Раз хэшкод де-факто неизменяем - почему бы не рассчитать его сразу?
//        В реальном проекте это было бы избыточно, просто первый раз при поиск работал бы чуть медленнее
//        (см. CarService).
//        Но мы вызываем метод поиска лишь единожды, неприятно его осознанно замедлять
        this.hashcode = hashCode();
    }

    public String getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActualTechnicalInspection() {
        return actualTechnicalInspection;
    }

    public void setActualTechnicalInspection(boolean actualTechnicalInspection) {
        this.actualTechnicalInspection = actualTechnicalInspection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !getClass().equals(o.getClass())) {
            return false;
        }

        Car car = (Car) o;

//        Учитываем в equals() лишь критичные для идентификации объекта поля.
//        Класс Objects содержит множество методов для работы с объектами.
//        equals(), hashcode(), проверки на null, сравнения и пр.
//        Удобен в тех случаях, когда мы не уверены, что значение (или хотя бы одно из значений)
//        не равно null
        return year == car.year && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
//        Если значение hashcode == 0 (значение поля типа int по умолчанию) - хэшкод еще не рассчитывался
//        (или поля заполнены 0 и null, но в рамках задачи для нас это не критично)
        if (hashcode == 0) {
//            рассчитаем хэшкод
            hashcode = number.hashCode();
            hashcode += 31 * year;
        }

//        если же хэшкод != 0 - его уже считали, смысла пересчитывать нет, т.к. исходные поля неизменяемы.
//        Просто вернем предрассчитанное значение
        return hashcode;
    }

    @Override
    public String toString() {
//        Метод formatted() у String позволяет создать строку с использованием спецификаторов
//        (как в System.out.printf()). До Java 15 вместо него использовался статический метод String.format().
//        Здесь он использован для большей наглядности кода, менее красиво, но с тем же успехом,
//        можно было обойтись обычной конкатенацией строк
        return """
                number: %s
                year: %d
                color: %s
                actualTechnicalInspection: %s
                """.formatted(
                number, year, color,
                actualTechnicalInspection ? "actual" : "not actual");
    }
}
