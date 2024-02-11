package com.walking.lesson46_lambda.task3.model;

public enum RequestType {
    SEARCH_BY_CAR_MODEL(1),
    SEARCH_BY_NUMBER_ALL(2),
    SEARCH_BY_NUMBER_SUBSTRING(3),
    SEARCH_BY_NUMBER_BETWEEN(4),
    EXIT(0);
    private final int index;
    RequestType(int index){
        this.index=index;
    }
    public int getIndex() {
        return index;
    }
    public static RequestType getValue(int index){
        for (RequestType e:RequestType.values()){
            if (e.getIndex()==index)
                return e;
        }
        throw new RuntimeException("Input request type error");
    }
}
