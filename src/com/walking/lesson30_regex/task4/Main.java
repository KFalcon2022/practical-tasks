package com.walking.lesson30_regex.task4;

import com.walking.lesson30_regex.task4.service.SentenceService;

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
        //String testString1="Мама мыла раму.\nИгорь ел песок.\nЗайчик пошел гулять.";
       // String testString2="Мама мыла Пашу.Он был очень грязный.Очень-очень.\nПотом они пошли гулять, чтобы снова испачкаться";
        //SentenceService textservice = new SentenceService(testString1);
       // SentenceService textService2 = new SentenceService(testString2);
        //System.out.println("Original text: "+testString1);
        //System.out.println("New text: "+textservice.getOriginalText());
        //System.out.println("Original text: "+testString2);
        //System.out.println("New text: "+textService2.getOriginalText());
        String testString3="""
                Java is one of the most popular: programming languages, often used for building web and enterprise scale applications. This collection of tutorials will help you get started with the basic concepts in Java?!
                Next, let's dive into the world - of object-oriented programming, with practical Java examples?
                Strings are a common data type in Java, representing text. Let's have a look at how to create and use String objects!
                """;
        SentenceService textSetrvice3=new SentenceService(testString3);
        System.out.println("Original:\n"+testString3);
        System.out.println("Modified:\n"+textSetrvice3.getOriginalText());
    }
}
