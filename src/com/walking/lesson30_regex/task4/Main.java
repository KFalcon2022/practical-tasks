package com.walking.lesson30_regex.task4;

import com.walking.lesson30_regex.task4.model.Text;

/**
 * Реализуйте программу, разбивающую исходный текст на составные части.
 * Текст – на абзацы (разделены ‘\n’), абзацы на предложения (разделены "."/ "?"/ "?!"/ "!"/ "…").
 * Предложения на слова (разделены пробелами,
 * но также могут использоваться знаки препинания ","/ "-", ":").
 * <p>
 * После этого выведите на экран исходный текст.
 * Предложения допустимо разделить точками,
 * слова – пробелами без сохранения знаков пунктуации внутри предложения.
 * Сохранение изначальной пунктуации, на мой взгляд,
 * излишне усложнит задачу и сдвинет акцент с практики регулярных выражений.
 * <p>
 * Подумайте, как наиболее корректно декомпозировать ваше решение.
 */
public class Main {
    public static void main(String[] args) {
        String testText = """
                После этого выведите на экран исходный текст. Предложения допустимо разделить точками, слова – пробелами без сохранения знаков пунктуации внутри предложения. Сохранение изначальной пунктуации, на мой взгляд, излишне усложнит задачу и сдвинет акцент с практики регулярных выражений.
                Подумайте, как наиболее корректно декомпозировать ваше решение.
                В качестве совета: попробуйте разные подходы для решения задачи, нет необходимости реализовать наиболее оптимальным способом. Например, одним из вариантов упрощения исходной задачи может стать избавление от лишних символов или их замена одним определенным через метод replaceAll() класса String.
                """;

        String testText1 = """
                Java is one of the most popular: programming languages, often used for building web and enterprise scale applications. This collection of tutorials will help you get started with the basic concepts in Java?!
                Next, let's dive into the world - of object-oriented programming, with practical Java examples?
                Strings are a common data type in Java, representing text. Let's have a look at how to create and use String objects!
                """;

        Text resultText = new Text(testText1);

        System.out.printf("Исходный текст:\n" + "%s\n" + "Полученный текст:\n" + "%s\n", testText1, resultText);
    }
}
