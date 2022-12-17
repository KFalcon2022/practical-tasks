package com.walking.lesson30_regex.task4.joiner;

import com.walking.lesson30_regex.task4.model.TextElement;

public class TextJoiner extends AbstractJoiner {
    @Override
    public String join(TextElement[] elements) {
        StringBuilder text = new StringBuilder();

        for (TextElement element : elements) {
            if (!text.isEmpty()) {
                text.append("\n");
            }

            text.append(element.getJoinedElement());
        }

        return text.toString();
    }
}
