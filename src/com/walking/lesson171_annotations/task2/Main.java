package com.walking.lesson171_annotations.task2;

import com.walking.lesson171_annotations.task2.model.PersonEntity;
import com.walking.lesson171_annotations.task2.service.TableQueryGenerator;

/**
 * Создайте ряд аннотаций для POJO, аналогичных или схожих с JPA аннотациями для Entity-классов
 * <p>
 * Опишите класс модели с любым названием и составом атрибутов. Аннотируйте класс и поля в количестве,
 * достаточном для представления таблицы, достаточной для хранения подобной модели.
 * <p>
 * Реализуйте чтение всех необходимых аннотаций и сформируйте SQL-запрос для создания таблицы в БД на основании данных
 * аннотаций и полей и названия класса.
 * <p>
 * Рекомендую ограничиться базовым набором:
 * <ul>
 * <li> Аннотации <code>@Table</code>, <code>@Column</code>, <code>@Id</code>;
 * <li> Поддержка только простых первичных ключей;
 * <li> Поддержка только базовых типов данных для моделей: примитивы и классы-обертки и строки.
 * </ul>
 * <p>
 * Реализация связей и FK, сложных constraint'ов, индексов, поддержка массивов и иных кастомных типов данных
 * необязательны. Однако при желании могут быть использованы для усложнения и более глубокого погружения в тему.
 */
public class Main {
    public static void main(String[] args) {
        var queryGenerator = new TableQueryGenerator();
        var createPersonQuery = queryGenerator.generateCreateTableQuery(PersonEntity.class);

        System.out.println(createPersonQuery);
    }
}
