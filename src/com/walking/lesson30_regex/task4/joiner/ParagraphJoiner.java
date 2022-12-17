package com.walking.lesson30_regex.task4.joiner;

import com.walking.lesson30_regex.task4.model.TextElement;

public class ParagraphJoiner extends AbstractJoiner {
    @Override
    public String join(TextElement[] elements) {
        StringBuilder paragraph = new StringBuilder();

        for (TextElement element : elements) {
            paragraph.append(element.getJoinedElement());
        }

        return paragraph.toString()
                .trim();
    }
}
