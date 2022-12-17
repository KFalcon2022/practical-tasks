package com.walking.lesson30_regex.task4.parser;

import com.walking.lesson30_regex.task4.model.TextElement;

public class SentenceParser extends AbstractParser {
    @Override
    public TextElement parse(TextElement textElement) {
        String formattedStr = textElement.getElement()
                .replaceAll("[,:]", " ")
                .replaceAll(" - ", " ")
                .trim();

        String[] parsedStrings = formattedStr.split(" +");
        TextElement[] children = new TextElement[parsedStrings.length];

        for (int i = 0; i < parsedStrings.length; i++) {
            children[i] = new TextElement(parsedStrings[i]);
        }

        textElement.setChildren(children);

        return textElement;
    }
}
