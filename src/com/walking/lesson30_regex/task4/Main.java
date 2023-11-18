package com.walking.lesson30_regex.task4;

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
import com.walking.lesson30_regex.task4.Text.Text;
public class Main {
    public static void main(String[] args) {
        String srcText = """
                Java is one of the most popular: programming languages, often used for building web and enterprise scale applications. This collection of tutorials will help you get started with the basic concepts in Java?!
                Next, let's dive into the world - of object-oriented programming, with practical Java examples?
                Strings are a common data type in Java, representing text. Let's have a look at how to create and use String objects!
                """;
        Text text = new Text(srcText);

        text.parseText();

        System.out.println("Source text");
        System.out.println(srcText);

        System.out.println("Processed text");
        System.out.println(text.getProcessedText( ));

    }
}
