package com.walking.lesson30_regex.task4.joiner;

import com.walking.lesson30_regex.task4.model.TextElement;

public class SentenceJoiner extends AbstractJoiner {
    @Override
    public String join(TextElement[] elements) {
        StringBuilder sentence = new StringBuilder();

        for (TextElement element : elements) {
            sentence.append(" ")
                    .append(element.getElement());
        }

        return sentence.append(".")
                .toString();
    }
}
