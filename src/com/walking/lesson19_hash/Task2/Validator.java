package com.walking.lesson19_hash.Task2;

public class Validator {
    
    public static Region validateRegion(int value) {
        Region result = Region.NONE;
        for (Region r : Region.values()) {
            if (r.getValue() == value){
                result = r;
                break;
            }
        }
        return result;
    }
    
}