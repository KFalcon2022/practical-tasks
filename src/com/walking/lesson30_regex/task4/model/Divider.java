package com.walking.lesson30_regex.task4.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Divider {
    private String input;
    private StrAndArr[] paragraphs;
    private int paragraphCount=0;
    private int sentenceCount=0;
    private int wordCount=0;

    public Divider(String inputString){
        this.input=inputString;
        divide();
    }

    private void divide(){
        Pattern parPattern=Pattern.compile("[^\n]+");
        Pattern sentPattern=Pattern.compile(".+?(\\?\\!|[\\.\\?\\!…])");
        Pattern wordPattern=Pattern.compile("[^,-:\\s]+");
        Matcher parMatcher=parPattern.matcher(input);
        Matcher sentMatcher;
        Matcher wordMatcher;      
        int parIndex=0;
        int sentIndex=0;
        int wordIndex=0;
        paragraphs=new StrAndArr[getMatcherCount(parPattern, input)];
        parMatcher=parPattern.matcher(input);
        while (parMatcher.find()) {
            paragraphs[parIndex]=new StrAndArr();
            paragraphs[parIndex].current=parMatcher.group();           
            sentMatcher=sentPattern.matcher(paragraphs[parIndex].current);
            paragraphs[parIndex].nextLvl=new StrAndArr[getMatcherCount(sentPattern, parMatcher.group())];
            while (sentMatcher.find()) {
                paragraphs[parIndex].nextLvl[sentIndex]=new StrAndArr();
                paragraphs[parIndex].nextLvl[sentIndex].current=sentMatcher.group();
                wordMatcher=wordPattern.matcher(paragraphs[parIndex].nextLvl[sentIndex].current);
                paragraphs[parIndex].nextLvl[sentIndex].nextLvl=new StrAndArr[getMatcherCount(wordPattern, sentMatcher.group())];
                while (wordMatcher.find()) {
                    paragraphs[parIndex].nextLvl[sentIndex].nextLvl[wordIndex]=new StrAndArr();
                    paragraphs[parIndex].nextLvl[sentIndex].nextLvl[wordIndex].current=wordMatcher.group();
                    wordIndex++;
                    wordCount++;
                }
                sentIndex++;
                sentenceCount++;
                wordIndex=0;
            }
            parIndex++;
            paragraphCount++;
            sentIndex=0;
        }
        
        
    }

    //Очень странно, что matcher.groupCount() не возвращает количество совпадений.
    private int getMatcherCount(Pattern pattern, String s){
        int i=0;
        Matcher matcher=pattern.matcher(s);
        while (matcher.find()) {
            i++;
        }
        return i;
    }

    public String[] getParagraphs(){
        String[] result=new String[paragraphCount];
        for (int i=0;i<paragraphs.length;i++){
            result[i]=paragraphs[i].current;
        }
        return result;
    }

    public String[] getSentences(){
        String[]result=new String[sentenceCount];
        int i=0;
        for(StrAndArr x:paragraphs){
            for (StrAndArr y : x.nextLvl) {
                result[i]=y.current;
                i++;
            }
        }
        return result;
    }

    public String[] getWords(){
        String[]result=new String[wordCount];
        int i=0;
        for(StrAndArr x:paragraphs){
            for (StrAndArr y : x.nextLvl) {
                for (StrAndArr z : y.nextLvl) {
                    result[i]=z.current;
                    i++;
                }
            }
        }
        return result;
    }

    public String getRestoredString(){
        StringBuilder result= new StringBuilder();
        for(StrAndArr x:paragraphs){
            for (StrAndArr y : x.nextLvl) {
                for (StrAndArr z : y.nextLvl) {
                    result.append(z.current+" ");
                }
                result=result.deleteCharAt(result.length()-1);
                result.append(". ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private class StrAndArr{
        String current;
        StrAndArr[] nextLvl;
    }
}
