package Lesson26.Task2;

import java.util.*;

public class StringSplitter {
    private final String validString;
    private ArrayList <String> array;
    private final int uniqueStr;
    public StringSplitter(String string)
    {
        validString = validateString(string.trim().toLowerCase());
        uniqueStr = splitString();
    }
    private String validateString(String s)
    {
        if (s.isBlank() || !s.contains(" ") || (s.length() < 10))
            throw new StrException(s);
        else return s;
    }
    private int splitString() {
        ArrayList<String> strarray = new ArrayList<>(Arrays.asList(validString.split("\\s+")));
        int counter = 0;
        Collections.sort(strarray);
        System.out.println(strarray);
        for (int i=0; i<strarray.size(); i++)
        {
            if (strarray.get(i).equals(strarray.get(i+1)))
            {
                strarray.remove(i);
                strarray.remove(i);
            }
        }
        array = strarray;
        return strarray.size();
    }

    public String toString()
    {
        return """
               Your line: [%s].
               Array: %s
               Unique Strings: %d
               """.formatted(validString, array, uniqueStr);
    }
}
