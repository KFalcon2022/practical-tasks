package com.walking.lesson171_annotations.task2.service;

import com.walking.lesson171_annotations.task2.annotation.Column;
import com.walking.lesson171_annotations.task2.annotation.Id;
import com.walking.lesson171_annotations.task2.annotation.Table;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * При формировании запроса ориентировался на PostgreSQL, могут быть небольшие отхождения от общего стандарта SQL.
 * В рамках задачи это не критично, но при реальной разработке такая вольность может быть недопустима
 */
public class TableQueryGenerator {
    private static final String CREATE_TABLE_TEMPLATE = """
            CREATE TABLE %s (
            %s
            );
            """;

    public String generateCreateTableQuery(Class<?> clazz) {
        var className = clazz.getName();

        if (clazz.isEnum() || clazz.isArray() || clazz.isPrimitive() || clazz.isInterface() || clazz.isAnnotation()) {
            throw new RuntimeException("Unavailable type of class %s".formatted(className));
        }

        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("Class %s is not annotated with @Table".formatted(className));
        }

        var tableName = getTableName(clazz);
        var columnsString = getColumns(clazz);

        return CREATE_TABLE_TEMPLATE.formatted(tableName, columnsString);
    }

    private String getTableName(Class<?> clazz) {
        var table = clazz.getAnnotation(Table.class);

        var schema = "".equals(table.schema()) ? "public" : table.schema();
        var tableName = "".equals(table.name()) ? clazz.getSimpleName() : table.name();

        return "%s.%s".formatted(schema, tableName);
    }

    // Данный подход будет обрабатывать статические (и даже static final) поля также, как и остальные,
    // что на практике часто избыточно. При желании, это можно доработать, как отфильтровывая такие поля
    // по модификаторам, так и через добавление аннотации, аналогичной @Transient в JPA
    private String getColumns(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .map(this::getColumn)
                .collect(Collectors.joining(",\n"));
    }

    private String getColumn(Field field) {
        var isId = field.isAnnotationPresent(Id.class);

        var column = field.getAnnotation(Column.class);
        var isNullable = column == null || column.nullable();
        var name = getFieldName(field, column);

        var sqlType = getSqlType(field);

        return "%s %s %s %s".formatted(
                name, sqlType,
                isId ? "PRIMARY KEY" : "",
                isNullable ? "" : "NOT NULL"
        );
    }

    private String getFieldName(Field field, Column column) {
        if (column == null) {
            return field.getName();
        }

        return "".equals(column.name()) ? field.getName() : column.name();
    }

    private String getSqlType(Field field) {
        var fieldClazz = field.getType();

        if (fieldClazz == String.class) {
            return "TEXT";
        }

        if (fieldClazz == int.class || fieldClazz == Integer.class) {
            return "INTEGER";
        }

        if (fieldClazz == long.class || fieldClazz == Long.class) {
            return "BIGINT";
        }

        if (fieldClazz == boolean.class || fieldClazz == Boolean.class) {
            return "BOOLEAN";
        }

        if (fieldClazz == float.class || fieldClazz == Float.class
                || fieldClazz == double.class || fieldClazz == Double.class) {
            return "DECIMAL";
        }

        if (fieldClazz == byte.class || fieldClazz == Byte.class
                || fieldClazz == short.class || fieldClazz == Short.class) {
            return "SMALLINT";
        }

        if (fieldClazz == char.class || fieldClazz == Character.class) {
            return "CHAR(1)";
        }

        throw new RuntimeException("Unavailable type %s for field %s".formatted(fieldClazz.getName(), field.getName()));
    }
}
