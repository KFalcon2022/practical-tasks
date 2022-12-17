package com.walking.lesson30_regex.task4.model;

public class TextElement {
    private final String element;
    private String joinedElement;
    private TextElement[] children;

    public TextElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public TextElement[] getChildren() {
        return children;
    }

    public void setChildren(TextElement[] children) {
        this.children = children;
    }

    public String getJoinedElement() {
        return joinedElement;
    }

    public void setJoinedElement(String joinedElement) {
        this.joinedElement = joinedElement;
    }
}
