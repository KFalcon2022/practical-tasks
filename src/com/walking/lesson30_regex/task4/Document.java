package com.walking.lesson30_regex.task4;

import java.util.Arrays;

public class Document {
    private Paragraph[] paragraphs;

    public Document(String fullText){
        String[] p = fullText.split("\n");
        this.paragraphs = new Paragraph[p.length];
        for (int i = 0; i < p.length; i++){
            this.paragraphs[i] = new Paragraph(p[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Paragraph paragraph: paragraphs) {
            res.append(paragraph);
        }

        return res.toString();

    }
}
