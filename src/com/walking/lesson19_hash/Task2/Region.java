package com.walking.lesson19_hash.Task2;

enum Region {
    NONE(0, ""),
    KARELIA(10, "Карелия"),
    KOMI(11, "Республика Коми"),
    ASTRAHAN(30, "Астраханская область"),
    KALUGA(40, "Калужская область"),
    KURSK(46, "Курская область"),
    MOSOBL50(50, "Московская область"),
    PSKOV(60, "Псковская область"),
    SARATOV64(64, "Саратовская область"),
    TOMSK(70, "Томская область"),
    MOSCOW77(77, "Москва"),
    YANAO(89, "Ямало-Ненецкий автономный округ");
    
    private int value;
    private String title;
    
    Region(int value, String title) {
        this.value = value;
        this.title = title;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String getTitle() {
        return this.title;
    }
}
