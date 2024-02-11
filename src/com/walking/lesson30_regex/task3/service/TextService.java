package com.walking.lesson30_regex.task3.service;

import com.walking.lesson30_regex.task3.exception.InvalidTextException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {
    private final static String dividerRegex = "\\s";
    private final static String invalidStringRegex1 = "[^А-Яа-я\\s-]|-{2,}";
    private int counter;
    private String[] wordsArray;
    private final String textString;
    public TextService(String textString){
            this.textString = textString;
            countWords();
    }
    public String[] getWordsArray(){
        return wordsArray;
    }
    private void createWordsArray(){
        wordsArray = textString.split(dividerRegex);
        for (String word : wordsArray){
            checkWordValidity(word);
        }
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
        createWordsArray();
        counter = wordsArray.length;
        String[] tempWords = wordsArray;
        for (int i=1;i<wordsArray.length;i++){
            String tempWord = wordsArray[i];
            tempWords[i]=tempWords[0];
            tempWords[0]=tempWord;
            for (int j=1;j<wordsArray.length;j++){
                if (tempWords[0].compareToIgnoreCase(wordsArray[j])==0){
                    counter--;
                }
            }
        }
    }
}
