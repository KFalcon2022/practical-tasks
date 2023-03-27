package com.walking.lesson30_regex.task4;

import java.util.Arrays;

public class Paragraph {
    private Clause[] clauses;

    public Paragraph(String clauses) {
        String[] cl = clauses.split("(\\.|!|\\?)");
        this.clauses = new Clause[cl.length];
        for (int i = 0; i < cl.length; i++){
            this.clauses[i] = new Clause(cl[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Clause clause: clauses) {
            if (res.length() > 0){
                res.append(' ');
            }
            res.append(clause);
        }

        return res.append('\n').toString();
    }
}
