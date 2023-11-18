package com.walking.lesson30_regex.task2.model;

import com.walking.lesson30_regex.task2.exception.NotMatchedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullName {
    private String name;
    private String secondName;
    private String surname;

    public FullName(String inputString){

        String regexp = "^([А-Я][а-я]*)(-[А-Я][а-я]*)?\\s([А-Я][а-я]*)\\s([А-Я][а-я]*)$";
        Pattern pattern = Pattern.compile(regexp,Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            int j;
            if (matcher.groupCount() == 4){
                this.surname = matcher.group(1);
            } else {
                this.surname = matcher.group(1)+matcher.group(2);
            }

            this.name = matcher.group(3);
            this.secondName = matcher.group(4);

        } else {
            throw new NotMatchedException();
        }
    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
