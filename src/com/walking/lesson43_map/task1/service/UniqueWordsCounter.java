package com.walking.lesson43_map.task1.service;

import com.walking.lesson30_regex.task3.service.TextService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueWordsCounter {
    private HashMap<String,Integer> uniqWords = new HashMap<>();
    private TextService textService;
    private ArrayList<String> words=new ArrayList<>();
    public UniqueWordsCounter(String text){
        textService=new TextService(text);
        getWordsArray();
        fillMap();
    }
    @Override
    public String toString(){
        StringBuilder resultString = new StringBuilder();
        for (Map.Entry<String,Integer> item:uniqWords.entrySet()){
            resultString.append(item.getKey());
            resultString.append(" - ");
            resultString.append(item.getValue());
            resultString.append("\n");
        }
        return resultString.toString();
    }
    private void fillMap(){
        for (String word:words){
            uniqWords.put(word,countWordRepeat(word));
        }
    }
    private int countWordRepeat(String inputWord){
        int counter=0;
        for (String word: textService.getWordsArray()){
            if (word.compareToIgnoreCase(inputWord)==0){
                counter++;
            }
        }
        return counter;
    }
    private void getWordsArray(){
        String[] tempWordsArray = textService.getWordsArray();

        for (String word1:tempWordsArray){
            int repeatCounter=0;
            for (String word2:tempWordsArray){
                if (word1.compareToIgnoreCase(word2)==0){
                    repeatCounter++;
                }
            }
            if (repeatCounter==1||!checkRepeat(word1)){
                words.add(word1);
            }
        }
    }
    private boolean checkRepeat(String inputWord){
        for (String word:words){
            if (word.compareToIgnoreCase(inputWord)==0){
                return true;
            }
        }
        return false;
    }
}
