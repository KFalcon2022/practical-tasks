package com.walking.lesson30_regex.task4;

import java.util.Arrays;

public class Clause {
    private String[] words;

    public Clause(String words) {
        this.words = words.split("(,|\\s|:|-)+");
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String word: words) {
            if (res.length() > 0){
                res.append(' ');
            }
            res.append(word);
        }

        return res.append('.').toString();
    }
}
