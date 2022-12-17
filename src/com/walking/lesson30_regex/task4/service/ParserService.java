package com.walking.lesson30_regex.task4.service;

import com.walking.lesson30_regex.task4.model.TextElement;
import com.walking.lesson30_regex.task4.parser.AbstractParser;
import com.walking.lesson30_regex.task4.parser.ParagraphParser;
import com.walking.lesson30_regex.task4.parser.SentenceParser;
import com.walking.lesson30_regex.task4.parser.TextParser;

public class ParserService {
    private final AbstractParser[] parsers;
    private final ValidationService validationService;

    public ParserService() {
        this.parsers = new AbstractParser[]{new TextParser(), new ParagraphParser(), new SentenceParser()};
        this.validationService = new ValidationService();
    }

    public TextElement parseText(String text) {
        validationService.validate(text);

        return parseText(new TextElement(text), 0);
    }

    private TextElement parseText(TextElement textElement, int parserIndex) {
        TextElement element = parsers[parserIndex].parse(textElement);

        if (parserIndex != parsers.length - 1) {
            for (TextElement child : element.getChildren()) {
                parseText(child, parserIndex + 1);
            }
        }

        return element;
    }
}
