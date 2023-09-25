package com.walking.lesson16_abstract_class_interface.task3.animals;

import com.walking.lesson16_abstract_class_interface.task3.PlayableSound;

public abstract class Animal implements PlayableSound {
    private final String NAME;
    protected final String SOUND;
    private final String CLASS_NAME;
    public Animal(String name,String sound,String className){
        this.NAME =name;
        this.SOUND=sound;
        this.CLASS_NAME=className;
    }
    public String getClassName(){
        return CLASS_NAME;
    }
    public String getNAME(){return NAME;}
}

