package com.walking.lesson26_string_types.task1;

public enum Symbol {
    LENGTH_SYMBOL("-"),
    WIDTH_SYMBOL("|"),
    SPACE_SYMBOL(" "),
    NEX_LINE(System.lineSeparator());

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
