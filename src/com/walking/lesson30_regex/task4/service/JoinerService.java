package com.walking.lesson30_regex.task4.service;

import com.walking.lesson30_regex.task4.joiner.AbstractJoiner;
import com.walking.lesson30_regex.task4.joiner.ParagraphJoiner;
import com.walking.lesson30_regex.task4.joiner.SentenceJoiner;
import com.walking.lesson30_regex.task4.joiner.TextJoiner;
import com.walking.lesson30_regex.task4.model.TextElement;

public class JoinerService {
    private final AbstractJoiner[] joiners;

    public JoinerService() {
        this.joiners = new AbstractJoiner[]{new TextJoiner(), new ParagraphJoiner(), new SentenceJoiner()};
    }

    public String joinText(TextElement textElement) {
        return joinText(textElement, 0);
    }

    private String joinText(TextElement textElement, int joinerIndex) {
        if (joinerIndex != joiners.length - 1) {
            for (TextElement child : textElement.getChildren()) {
                joinText(child, joinerIndex + 1);
            }
        }

        textElement.setJoinedElement(joiners[joinerIndex].join(textElement.getChildren()));

        return textElement.getJoinedElement();
    }
}
