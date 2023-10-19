package com.walking.lesson30_regex.task3.service;

import com.walking.lesson30_regex.task3.exception.InvalidTextException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {
    private final static String dividerRegex = "\\s";
    private final static String invalidStringRegex1 = "[^А-Яа-я\\s-]|-{2,}";
    private int counter;
    private final String textString;
    public TextService(String textString){
            this.textString = textString;
            countWords();
    }
    private String[] getWordsArray(){
        String[] words = textString.split(dividerRegex);
        for (String word : words){
            checkWordValidity(word);
        }
        return words;
    }
    public int getCounter(){
        return counter;
    }
    private void checkWordValidity(String inputWord){
        Pattern pattern = Pattern.compile(invalidStringRegex1);
        Matcher invalidStringRegex = pattern.matcher(inputWord);
        if (invalidStringRegex.find()){
            throw new InvalidTextException(inputWord);
        }
    }
    private void countWords(){
        String[] words = getWordsArray();
        counter = words.length;

        String[] tempWords = words;
        for (int i=1;i<words.length;i++){
            String tempWord = words[i];
            tempWords[i]=tempWords[0];
            tempWords[0]=tempWord;
            for (int j=1;j<words.length;j++){
                if (tempWords[0].compareToIgnoreCase(words[j])==0){
                    counter--;
                }
            }
        }
    }
}
