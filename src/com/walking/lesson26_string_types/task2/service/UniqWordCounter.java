package com.walking.lesson26_string_types.task2.service;

public class UniqWordCounter {
    private String inputString;
    public UniqWordCounter(String inputString){
        this.inputString=inputString;
        System.out.println("You entered: "+inputString);
    }
    private int wordsCounter=0;
    private final String divider = " ";
    private void stripString(){
        inputString=inputString.strip();
    }
    public int findUniqWords(){
        stripString();
        inputString=deleteAdditionSpaces();
        String[] wordsArray = inputString.split(divider);
        for (int i=0;i<wordsArray.length;i++){
            if (isUniquePrevious(i,wordsArray)&&isUniqueNext(i,wordsArray)){
                wordsCounter++;
            }
        }
        return wordsCounter;
    }
    private boolean isUniquePrevious(int position,String[] wordsArray){
        boolean isUnique=true;
        for (int i=position-1;i>=0;i--){
            if (wordsArray[position].compareToIgnoreCase(wordsArray[i])==0){
                isUnique=false;
            }
            else isUnique=true;
        }
        return isUnique;
    }
    private boolean isUniqueNext(int position, String[] wordsArray){
        boolean isUnique=true;
        for (int i=position+1;i<wordsArray.length;i++){
            if (wordsArray[position].compareToIgnoreCase(wordsArray[i])==0){
                return false;
            }
            else isUnique=true;
        }
        return isUnique;
    }
    private String deleteAdditionSpaces (){
        String returnString="";
        char[] allChars = inputString.toCharArray();
        for (int i=0;i<allChars.length;i++){
            if (allChars[i]==' ' && allChars[i]==allChars[i+1]){
                continue;
            }
            returnString+=allChars[i];
        }
        return returnString;
    }
}
