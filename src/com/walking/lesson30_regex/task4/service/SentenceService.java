package com.walking.lesson30_regex.task4.service;

import java.util.Objects;

public class SentenceService {
    private final String textAll;
    private final String[] textParagraphs;
    private final String[] textSentences;
    private final String[] textWords;
    private String textReplacedParagraphs;
    private String textReplacedSentences;
    private final String paragraphRegex = "\\n";
    private final String sentenceRegex="([.…]|[?!]{1,2}) ?";
    private final String wordRegex="[ ,\\-:]";
    private final String spaceRegex=" {2,}";
    public SentenceService(String textAll){
        textReplacedParagraphs=textAll.replaceAll(paragraphRegex,"");
        textReplacedSentences=textReplacedParagraphs.replaceAll(sentenceRegex," ");
        textReplacedSentences=textReplacedSentences.replaceAll(wordRegex," ");
        this.textAll=textAll;
        deleteAdditionSpaces();
        textParagraphs=getParagraphs();
        textSentences=getSentences();
        textWords=getWords();
    }
    private String[] getParagraphs(){
        String tempStr=textAll.replaceAll(wordRegex," ");
        tempStr=tempStr.replaceAll("[?!]{2}",".");
        tempStr=tempStr.replaceAll(sentenceRegex,".");
        tempStr=tempStr.replaceAll(spaceRegex," ");
        return tempStr.split(paragraphRegex);
    }
    private String[] getSentences(){
        return textReplacedParagraphs.split(sentenceRegex);
    }
    private String[] getWords(){
        return textReplacedSentences.split(wordRegex);
    }
    public String getOriginalText() {
        StringBuilder resultText = new StringBuilder(); //Финальная строка-результат
        int indexSentence = 0; //Индекс массива предложений
        int indexParagraph = 0; //Индекс массива абзацев
        //Рассматриваем первый параграф и первое предложение соответственно
        String tempParagraph=textParagraphs[indexParagraph];
        String tempSentence=textSentences[indexSentence];
        for (int j = 0; j < textWords.length; j++) { // Перебираем все слова
            resultText.append(textWords[j]);
            if (Objects.equals(resultText.toString(), tempSentence)) { // Когда набор слов равен первому предложению
                resultText.append("."); //Завершаем его точкой
                indexSentence++; // переходим к следующему предложению
                tempSentence += "."; //Точка для единообразия с стрингбилдером
                if (Objects.equals(resultText.toString(), tempParagraph)) { //Когда набор слов равен абзацу
                    resultText.append("\n"); // Делаем аналогично предложению, но с \n
                    tempSentence+="\n";
                    indexParagraph++;
                    if (indexParagraph < textParagraphs.length) {
                        tempParagraph += "\n" + textParagraphs[indexParagraph];
                    }
                }
                if (indexSentence < textSentences.length) {
                    tempSentence +=textSentences[indexSentence];
                }
                continue;
            }
            resultText.append(" ");
        }
        return resultText.toString();
    }
    private void deleteAdditionSpaces(){
        // Удаление двойных и более пробелов (могли остаться после замены)
        textReplacedParagraphs=textReplacedParagraphs.replaceAll(wordRegex," ");
        textReplacedParagraphs=textReplacedParagraphs.replaceAll(spaceRegex," ");
        textReplacedSentences=textReplacedSentences.replaceAll(spaceRegex," ");
    }
}
